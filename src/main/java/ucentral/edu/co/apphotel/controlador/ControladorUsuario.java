package ucentral.edu.co.apphotel.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ucentral.edu.co.apphotel.dto.ReservaDto;
import ucentral.edu.co.apphotel.dto.UsuarioDto;
import ucentral.edu.co.apphotel.entidades.Usuario;
import ucentral.edu.co.apphotel.servicios.ServicioUsuarios;

import java.util.List;

@Controller
public class ControladorUsuario {


    private final ServicioUsuarios servicioUsuarios;

    public ControladorUsuario(ServicioUsuarios servicioUsuarios) {
        this.servicioUsuarios = servicioUsuarios;
    }

    @GetMapping(value = "/registro")
    public String registro(Model model) {
        UsuarioDto usuarioLlenar = new UsuarioDto();
        model.addAttribute("usuarioLlenar", usuarioLlenar);
        return "registro";
    }
    @PostMapping("/login")
    public String procesarLogin(@RequestParam String correo, @RequestParam String contrasena, Model model) {

        List<UsuarioDto> listaUsuarios = servicioUsuarios.consultarL();
        model.addAttribute("listaUsuarios", listaUsuarios);
        for (UsuarioDto usuario : listaUsuarios) {
            if (usuario.getCorreo().equals(correo) && usuario.getContrasena().equals(contrasena)) {
                model.addAttribute("mensaje", "Inicio de sesión exitoso");
                return "redirect:/inicio";
            }
        }

        model.addAttribute("error", "Correo o contraseña incorrectos");
        return "sesion";
    }
    @PostMapping("/register")
    public String registrarUsuario(@ModelAttribute("usuarioLlenar") UsuarioDto usuario){
        servicioUsuarios.crearL(usuario);
        return "redirect:/register/login";
    }
    @GetMapping("/register/login")
    public String cargarUsuarioModal(Model model){
        UsuarioDto usuarioLlenar = new UsuarioDto();
        model.addAttribute("usuarioLlenar", usuarioLlenar);
        return "sesion";
    }
    @GetMapping(value = "/logout")
    public String logout() {
        return "sesion";
    }

}

