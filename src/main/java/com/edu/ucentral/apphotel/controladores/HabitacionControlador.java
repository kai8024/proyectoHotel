package com.edu.ucentral.apphotel.controladores;

import com.edu.ucentral.apphotel.dto.ReservaDto;
import com.edu.ucentral.apphotel.servicios.ReservaServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/habitacion")
public class HabitacionControlador {



    @GetMapping("/lista")
    public String listarHabitaciones(Model model) {

        return "habitacion/lista"; // Ruta de la plantilla para mostrar habitaciones
    }


}
