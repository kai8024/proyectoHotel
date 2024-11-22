package ucentral.edu.co.apphotel.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucentral.edu.co.apphotel.entidades.Pago;


@Repository
public interface RepoPago extends JpaRepository<Pago,Long> {
}
