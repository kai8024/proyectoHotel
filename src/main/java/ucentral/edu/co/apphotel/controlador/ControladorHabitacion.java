package ucentral.edu.co.apphotel.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ucentral.edu.co.apphotel.dto.ReservaDto;
import ucentral.edu.co.apphotel.servicios.ServicioHabitaciones;
import ucentral.edu.co.apphotel.servicios.ServicioReservas;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ControladorHabitacion {
    private final ServicioReservas servicioReservas;

    public ControladorHabitacion(ServicioReservas servicioReservas) {
        this.servicioReservas = servicioReservas;
    }


   @PostMapping("/buscar/disponibilidad")
    public String buscarHabitacion(@RequestParam String habitacion,@RequestParam String hotel, Model model) {
        // Obtener la lista completa de reservas
        List<ReservaDto> listaReservas = servicioReservas.consultarT();

        // Filtrar las reservas que coincidan con el hotel buscado
        List<ReservaDto> habitacionesFiltradas = listaReservas.stream()
                .filter(reserva -> reserva.getHabitacion().equalsIgnoreCase(habitacion) && reserva.getHotel().equalsIgnoreCase(hotel))
                .collect(Collectors.toList());

        // Verificar si hay resultados
        if (habitacionesFiltradas.isEmpty()) {
            model.addAttribute("mensaje", "No se encontraron reservas para la habitacion: " + habitacion);
            return "disponibilidad"; // Página que muestra el mensaje de no resultados
        }

        // Agregar las reservas filtradas al modelo
        model.addAttribute("listaReservas", habitacionesFiltradas);
        return "calendario"; // Página para mostrar las reservas filtradas
    }


    @GetMapping("/disponibilidad")
    public String cargarDisponibilidadModal(Model model){
        return "disponibilidad";
    }

    @GetMapping("/misReservas")
    public String misReservas(Model model){
        return "misReservas";
    }

    @GetMapping("/calendario")
    public String calendario(@RequestParam String hotel,Model model){
        /*List<String> listaReservas = List.of("2024-11-20", "2024-11-22", "2024-11-25");
        model.addAttribute("listaReservas", listaReservas);*/
        List<ReservaDto> listaReservas = servicioReservas.consultarT();
        model.addAttribute("listaReservas", listaReservas);
        return "calendario";
    }

    @GetMapping("/fechas")
    public List<String> obtenerFechasReservadas() {
        // Aquí obtendrás las fechas reservadas desde tu base de datos
        List<LocalDate> fechasReservadas = servicioReservas.obtenerFechasReservadas();
        // Convertir las fechas a formato "yyyy-MM-dd" para pasarlas al frontend
        return fechasReservadas.stream()
                .map(date -> date.toString())  // Convierte LocalDate a String (yyyy-MM-dd)
                .collect(Collectors.toList());
    }
}
