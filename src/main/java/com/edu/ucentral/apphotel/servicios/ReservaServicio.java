package com.edu.ucentral.apphotel.servicios;

import com.edu.ucentral.apphotel.dto.ReservaDto;
import com.edu.ucentral.apphotel.entidades.Reserva;
import com.edu.ucentral.apphotel.operaciones.OperacionesReserva;
import com.edu.ucentral.apphotel.repositorios.RepoReserva;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServicio implements OperacionesReserva {
    @Autowired
    RepoReserva repoReserva;
    @Autowired
    ModelMapper modelMapper;

    public ReservaServicio(ModelMapper modelMapper, RepoReserva repoReserva) {
        this.modelMapper = modelMapper;
        this.repoReserva = repoReserva;
    }

    @Override
    public void crear(ReservaDto reserva) {
        Reserva reservas = modelMapper.map(reserva,Reserva.class);
        repoReserva.save(reservas);
    }

    @Override
    public List<ReservaDto> consultarT() {
        TypeToken<List<ReservaDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(repoReserva.findAll(), typeToken.getType());
    }

    @Override
    public ReservaDto findDtoById(Long id) {
        Reserva reserva = repoReserva.findById(id).orElse(null);
        return reserva != null ? modelMapper.map(reserva, ReservaDto.class) : null;
    }
    /*@Autowired
    private ReservaRepositorio reservaRepositorio;

    // Método para obtener las reservas activas del usuario
    public List<Reserva> obtenerReservasActivasDelUsuario() {
        // Aquí debemos asumir que tenemos una sesión de usuario y obtener sus reservas activas
        // Esto podría ser algo como obtener las reservas donde "estado" = "activa" y el usuario es el actual.

        return null;
    }*/
}
