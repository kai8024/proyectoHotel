package ucentral.edu.co.apphotel.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucentral.edu.co.apphotel.entidades.Habitacion;

import java.util.List;

@Repository
public interface RepoHabitacion extends JpaRepository<Habitacion,Long> {
    //List<Habitacion> findAllByIdNotIn(List<Long> ids);
}
