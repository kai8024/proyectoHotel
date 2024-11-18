package ucentral.edu.co.apphotel.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucentral.edu.co.apphotel.entidades.Habitacion;
import ucentral.edu.co.apphotel.entidades.Reserva;
import ucentral.edu.co.apphotel.repositorios.RepoHabitacion;
import ucentral.edu.co.apphotel.repositorios.RepoReserva;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioHabitaciones {
    @Autowired
    private RepoReserva repoReserva;

    @Autowired
    private RepoHabitacion repoHabitacion;

    /*public List<Habitacion> buscarDisponibilidad(LocalDate entrada, LocalDate salida) {
        List<Long> habitacionesReservadas = repoReserva.findHabitacionesReservadas(entrada, salida);
        return repoHabitacion.findAllByIdNotIn(habitacionesReservadas);
    }*/
}
