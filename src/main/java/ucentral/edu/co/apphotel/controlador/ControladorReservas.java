package ucentral.edu.co.apphotel.controlador;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import ucentral.edu.co.apphotel.dto.ReservaDto;

import ucentral.edu.co.apphotel.servicios.ServicioReservas;

import java.util.List;


@Controller
public class ControladorReservas {

    private final ServicioReservas servicioReservas;

    public ControladorReservas(ServicioReservas servicioReservas) {
        this.servicioReservas = servicioReservas;
    }

    @GetMapping(value = "/")
    public String inicio() {
        return "sesion";
    }

    @GetMapping(value = "/inicio")
    public String portal() {
        return "portal";
    }


    @PostMapping("/reserva/nuevo")
    public String accioncrear(@ModelAttribute("reservaLlenar") ReservaDto reserva, Model model){

        if (reserva.getSalida().isBefore(reserva.getEntrada())) {
            model.addAttribute("error", "La fecha de salida no puede ser anterior a la fecha de entrada.");
            return "reservas"; // Nombre de la vista del formulario de reserva
        }

        boolean conflicto = servicioReservas.existeConflictoDeFechas(
                reserva.getHotel(),
                reserva.getHabitacion(),
                reserva.getEntrada(),
                reserva.getSalida()
        );

        if (conflicto) {
            // Agregar un mensaje de error al modelo
            model.addAttribute("error", "La reserva no se puede realizar. Las fechas seleccionadas ya están ocupadas.");
            return "reservas"; // Nombre de la vista del formulario de reserva
        }
        servicioReservas.crear(reserva);
        return "redirect:/reserva/registrar";
    }
    @GetMapping("/reserva/registrar")
    public String cargarReservaModal(@RequestParam(required = false) String habitacion, Model model) {
        ReservaDto reservaLlenar = new ReservaDto();

        model.addAttribute("habitacion", habitacion);
        model.addAttribute("reservaLlenar", reservaLlenar);
        return "reservas";
    }

    @GetMapping("/reserva/listar")
    public String mostrar(Model model){
        List<ReservaDto> listaReservas = servicioReservas.consultarT();
        model.addAttribute("listaReservas", listaReservas);
        return "listar";
    }

}
