package com.edu.ucentral.apphotel.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HotelControlador {

    @GetMapping(value = "/inicio")
    public String inicio() {
        return "inicio";  // Debe redireccionar a inicio.html en /templates
    }

    // Otros métodos y rutas de tu controlador Hotel
}
