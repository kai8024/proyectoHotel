package com.edu.ucentral.apphotel.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HotelControlador {

    @GetMapping(value = "/")
    public String inicio() {
        return "inicio";  // Redirecciona a inicio.html
    }

    // Otros métodos y rutas de tu controlador Hotel
}
