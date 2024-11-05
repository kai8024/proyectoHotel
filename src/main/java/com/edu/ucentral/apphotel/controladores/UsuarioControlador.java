package com.edu.ucentral.apphotel.controladores;

import com.edu.ucentral.apphotel.persistencia.entidades.Usuario;
import com.edu.ucentral.apphotel.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class UsuarioControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostMapping("/login")
    public String login(@RequestParam String correo, @RequestParam String contraseña, Model model) {
        var usuarioOpt = usuarioServicio.autenticarUsuario(correo, contraseña);
        if (usuarioOpt.isPresent()) {
            model.addAttribute("usuario", usuarioOpt.get());
            return "redirect:/inicio";  // Redirige a la página de inicio principal después de un login exitoso
        } else {
            model.addAttribute("error", "Correo o contraseña incorrectos");
            return "login"; // Redirige de nuevo a la página de login en caso de error
        }
    }

    @GetMapping("/registro")
    public String mostrarRegistro() {
        return "registro";
    }

    @PostMapping("/registro")
    public String registrarUsuario(@RequestParam String nombre, @RequestParam String correo,
                                   @RequestParam String contraseña, @RequestParam int numTel) {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombreUsuario(nombre);
        nuevoUsuario.setCorreoUsuario(correo);
        nuevoUsuario.setContraseña(contraseña);
        nuevoUsuario.setNumTelUsuario(numTel);
        usuarioServicio.registrarUsuario(nuevoUsuario);
        return "redirect:/login";  // Redirige a la página de login después de un registro exitoso
    }
}
