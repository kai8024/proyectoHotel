package ucentral.edu.co.apphotel.controlador;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ucentral.edu.co.apphotel.dto.ReservaDto;
import ucentral.edu.co.apphotel.entidades.Reserva;
import ucentral.edu.co.apphotel.servicios.ServicioReservas;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class ControladorHabitacion {
    private final ServicioReservas servicioReservas;

    public ControladorHabitacion(ServicioReservas servicioReservas) {
        this.servicioReservas = servicioReservas;
    }





    @GetMapping("/individual")
    public String individual(Model model){
        return "individual";
    }

    @GetMapping("/doble")
    public String doble(Model model){
        return "doble";
    }

    @GetMapping("/suite")
    public String suite(Model model){
        return "suite";
    }


    @GetMapping("/disponibilidad")
    public String cargarDisponibilidadModal(Model model){
        List<ReservaDto> listaReservas = servicioReservas.consultarT();
        List<String> hoteles = listaReservas.stream()
                .map(ReservaDto::getHotel)
                .distinct()
                .collect(Collectors.toList());
        model.addAttribute("hoteles", hoteles);
        return "disponibilidad";
    }


    @GetMapping("/calendario")
    public String calendario(Model model) {
        List<ReservaDto> listaReservas = servicioReservas.consultarT();

        // Preparamos las fechas reservadas como objetos JSON
        List<Map<String, String>> reservedDates = new ArrayList<>();
        for (ReservaDto reserva : listaReservas) {
            Map<String, String> dateRange = new HashMap<>();
            dateRange.put("start", reserva.getEntrada().toString());  // Convertimos la fecha de entrada a String
            dateRange.put("end", reserva.getSalida().toString());     // Convertimos la fecha de salida a String
            reservedDates.add(dateRange);
        }

        // Pasamos la lista de fechas reservadas al modelo
        model.addAttribute("reservedDates", reservedDates);
        return "calendario";
    }


    @PostMapping("/buscar/disponibilidad")
    public String buscarHabitacion(@RequestParam Long habitacion,@RequestParam String hotel, Model model) {
        // Obtener la lista completa de reservas
        List<ReservaDto> listaReservas = servicioReservas.consultarT();

        // Filtrar las reservas que coincidan con el hotel buscado
        List<ReservaDto> habitacionesFiltradas = listaReservas.stream()
                .filter(reserva -> reserva.getHabitacion().equals(habitacion) && reserva.getHotel().equalsIgnoreCase(hotel))
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
}
