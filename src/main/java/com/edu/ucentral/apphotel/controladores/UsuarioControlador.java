package com.edu.ucentral.apphotel.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioControlador {

    @GetMapping("/lista")
    public String listarUsuarios(Model model) {
        // Lógica para obtener la lista de usuarios
        return "usuario/lista"; // Ruta de la plantilla para mostrar usuarios
    }
}
