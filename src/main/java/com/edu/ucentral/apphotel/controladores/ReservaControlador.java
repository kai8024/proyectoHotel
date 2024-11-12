package com.edu.ucentral.apphotel.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reserva")
public class ReservaControlador {

    @GetMapping("/lista")
    public String listarReservas(Model model) {
        // Lógica para obtener la lista de reservas
        return "reserva/lista"; // Ruta de la plantilla para mostrar reservas
    }
}
