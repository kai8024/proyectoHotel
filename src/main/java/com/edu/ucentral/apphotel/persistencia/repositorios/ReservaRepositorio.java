package com.edu.ucentral.apphotel.persistencia.repositorios;

import com.edu.ucentral.apphotel.persistencia.entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepositorio extends JpaRepository<Reserva, Integer> {
    // Aquí puedes agregar consultas personalizadas si es necesario
}
