package com.edu.ucentral.apphotel.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/habitacion")
public class HabitacionControlador {

    @GetMapping("/lista")
    public String listarHabitaciones(Model model) {
        // Lógica para obtener la lista de habitaciones
        return "habitacion/lista"; // Ruta de la plantilla para mostrar habitaciones
    }
}
