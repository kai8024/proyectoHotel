package com.edu.ucentral.apphotel.servicios;

import com.edu.ucentral.apphotel.persistencia.entidades.Reserva;
import com.edu.ucentral.apphotel.persistencia.repositorios.ReservaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServicio {

    @Autowired
    private ReservaRepositorio reservaRepositorio;

    // Método para obtener las reservas activas del usuario
    public List<Reserva> obtenerReservasActivasDelUsuario() {
        // Aquí debemos asumir que tenemos una sesión de usuario y obtener sus reservas activas
        // Esto podría ser algo como obtener las reservas donde "estado" = "activa" y el usuario es el actual.

        return null;
    }
}
