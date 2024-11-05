package com.edu.ucentral.apphotel.controladores;

import com.edu.ucentral.apphotel.persistencia.entidades.Usuario;
import com.edu.ucentral.apphotel.persistencia.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginControlador {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login"; // Muestra la página login.html
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam("correo_usuario") String correo,
                                @RequestParam("password") String password,
                                Model model) {
        Optional<Usuario> usuario = usuarioRepositorio.findByCorreoUsuario(correo);

        if (usuario.isPresent() && usuario.get().getPassword().equals(password)) {
            // Autenticación exitosa
            model.addAttribute("usuario", usuario);
            return "redirect:/inicio"; // Redirige a la página principal
        } else {
            // Autenticación fallida
            model.addAttribute("error", "Correo o contraseña incorrectos");
            return "login";
        }
    }
}
