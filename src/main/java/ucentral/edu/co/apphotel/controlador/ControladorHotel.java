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
    public String cargarHotelModal(Model model){
        return "hotel";
    }

   @PostMapping("/buscar")
   public String buscarHotel(@RequestParam String hotel, Model model) {
       // Obtener la lista completa de reservas
       List<ReservaDto> listaReservas = servicioReservas.consultarT();

       // Filtrar las reservas que coincidan con el hotel buscado
       List<ReservaDto> reservasFiltradas = listaReservas.stream()
               .filter(reserva -> reserva.getHotel().equalsIgnoreCase(hotel))
               .collect(Collectors.toList());

       // Verificar si hay resultados
       if (reservasFiltradas.isEmpty()) {
           model.addAttribute("mensaje", "No se encontraron reservas para el hotel: " + hotel);
           return "hotel"; // Página que muestra el mensaje de no resultados
       }

       // Agregar las reservas filtradas al modelo
       model.addAttribute("listaReservas", reservasFiltradas);
       return "listar"; // Página para mostrar las reservas filtradas
   }
}
