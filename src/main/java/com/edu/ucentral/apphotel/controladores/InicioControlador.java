package com.edu.ucentral.apphotel.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioControlador {

    @GetMapping("/inicio")
    public String mostrarInicio() {
        return "inicio"; // Retorna el nombre del archivo HTML sin extensión
    }
}
