package ucentral.edu.co.apphotel.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import ucentral.edu.co.apphotel.entidades.DiaReserva;

import java.time.LocalDate;

public interface RepoDiaReserva extends JpaRepository<DiaReserva, LocalDate> {
}
