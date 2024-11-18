package ucentral.edu.co.apphotel.controlador;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String accioncrear(@ModelAttribute("reservaLlenar") ReservaDto reserva){
        servicioReservas.crear(reserva);
        return "redirect:/reserva/registrar";
    }
    @GetMapping("/reserva/registrar")
    public String cargarReservaModal(Model model){
        ReservaDto reservaLlenar = new ReservaDto();
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
