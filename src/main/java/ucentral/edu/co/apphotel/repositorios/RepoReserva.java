package ucentral.edu.co.apphotel.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ucentral.edu.co.apphotel.entidades.Reserva;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RepoReserva extends JpaRepository<Reserva,Long>{
    @Query("SELECT r.habitacion FROM Reserva r WHERE " +
            "(r.entrada <= :salida AND r.salida >= :entrada)")
    List<Long> findHabitacionesReservadas(@Param("entrada") LocalDate entrada,
                                          @Param("salida") LocalDate salida);
}
