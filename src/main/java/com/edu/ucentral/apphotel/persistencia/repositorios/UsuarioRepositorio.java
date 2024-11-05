package com.edu.ucentral.apphotel.persistencia.repositorios;

import com.edu.ucentral.apphotel.persistencia.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByCorreoUsuario(String correoUsuario);

    Usuario save(Usuario usuario);
}
