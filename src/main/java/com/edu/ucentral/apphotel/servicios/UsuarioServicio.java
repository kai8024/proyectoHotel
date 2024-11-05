package com.edu.ucentral.apphotel.servicios;

import com.edu.ucentral.apphotel.persistencia.entidades.Usuario;
import com.edu.ucentral.apphotel.persistencia.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public Optional<Usuario> autenticarUsuario(String correo, String contraseña) {
        Optional<Usuario> usuarioOpt = usuarioRepositorio.findByCorreoUsuario(correo);
        return usuarioOpt.filter(usuario -> usuario.getContraseña().equals(contraseña));
    }

    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }
}
