package com.edu.ucentral.apphotel.controladores;

import com.edu.ucentral.apphotel.persistencia.entidades.Reserva;
import com.edu.ucentral.apphotel.servicios.ReservaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReservaControlador {

    @Autowired
    private ReservaServicio reservaServicio;

    @GetMapping("/misReservas")
    public String mostrarMisReservas(Model model) {
        // Aquí recuperamos las reservas del usuario (suponiendo que tenemos un método que lo hace)
        List<Reserva> reservasActivas = reservaServicio.obtenerReservasActivasDelUsuario();

        if (reservasActivas.isEmpty()) {
            model.addAttribute("mensaje", "No tienes reservas activas.");
        } else {
            model.addAttribute("reservas", reservasActivas);
        }

        return "reservas";  // Se asume que la vista se llama "reservas.html"
    }
}
