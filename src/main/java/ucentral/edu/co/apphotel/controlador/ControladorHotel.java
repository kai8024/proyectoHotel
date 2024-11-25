package ucentral.edu.co.apphotel.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ucentral.edu.co.apphotel.dto.ReservaDto;
import ucentral.edu.co.apphotel.dto.UsuarioDto;
import ucentral.edu.co.apphotel.servicios.ServicioHabitaciones;
import ucentral.edu.co.apphotel.servicios.ServicioReservas;
import ucentral.edu.co.apphotel.servicios.ServicioUsuarios;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ControladorHotel {

    private final ServicioReservas servicioReservas;

    public ControladorHotel(ServicioReservas servicioReservas) {
        this.servicioReservas = servicioReservas;
    }


    @GetMapping("/hotel")
    public String mostrarFormularioBusqueda(Model model) {
        List<ReservaDto> listaReservas = servicioReservas.consultarT();
        List<String> hoteles = listaReservas.stream()
                .map(ReservaDto::getHotel)
                .distinct()
                .collect(Collectors.toList());
        model.addAttribute("hoteles", hoteles);
        return "hotel";
    }

    @PostMapping("/buscar/hotel")
    public String buscarHotel(@RequestParam String hotel, Model model) {
        List<ReservaDto> listaReservas = servicioReservas.consultarT();
        List<ReservaDto> reservasFiltradas = listaReservas.stream()
                .filter(reserva -> reserva.getHotel().equalsIgnoreCase(hotel))
                .collect(Collectors.toList());

        if (reservasFiltradas.isEmpty()) {
            model.addAttribute("mensaje", "No se encontraron reservas para el hotel: " + hotel);
            return "hotel";
        }

        model.addAttribute("listaReservas", reservasFiltradas);
        return "listar";
    }

    @GetMapping("/sitios")
    public String sitios(Model model){
        return "sitios";
    }
}