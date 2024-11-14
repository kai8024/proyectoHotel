package com.edu.ucentral.apphotel.controladores;

import com.edu.ucentral.apphotel.dto.ReservaDto;
import com.edu.ucentral.apphotel.entidades.Reserva;
import com.edu.ucentral.apphotel.servicios.ReservaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ReservaControlador {

    @Autowired
    private ReservaServicio reservaServicio;
    @Autowired
    private ReservaServicio reservaServicios;
    /*@Autowired
    private ServicioResultados servicioResultados;*/
    //private final ReservaServicio reservaServicio;

    public ReservaControlador(ReservaServicio reservaServicio) {
        this.reservaServicio = reservaServicio;
    }


    /*@GetMapping("/misReservas")
    public String mostrarMisReservas(Model model) {
        // Aquí recuperamos las reservas del usuario (suponiendo que tenemos un método que lo hace)
        List<Reserva> reservasActivas = reservaServicio.obtenerReservasActivasDelUsuario();

        if (reservasActivas.isEmpty()) {
            model.addAttribute("mensaje", "No tienes reservas activas.");
        } else {
            model.addAttribute("reservas", reservasActivas);
        }

        return "reservas";  // Se asume que la vista se llama "reservas.html"
    }*/

    @GetMapping(value = "/")
    public String prueba() {
        return "prueba";  // Debe redireccionar a inicio.html en /templates
    }

    @PostMapping("/hotel/nuevo")
    public String accioncrear(@ModelAttribute("hotelLlenar") ReservaDto reserva){
        reservaServicio.crear(reserva);
        return "redirect:/equipo/inscripcion";
    }
    // Otros métodos y rutas de tu controlador Hotel
}
    /*@PostMapping("/equipo/nuevo")
    public String accioncrear(@ModelAttribute("equipoLlenar") EquiposDto equipo){
        servicioEquipos.crear(equipo);
        return "redirect:/equipo/inscripcion";
    }*/

