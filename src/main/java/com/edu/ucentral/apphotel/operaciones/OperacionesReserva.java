package com.edu.ucentral.apphotel.operaciones;

import com.edu.ucentral.apphotel.dto.ReservaDto;

import java.util.List;

public interface OperacionesReserva {
    void crear(ReservaDto reserva);
    public List<ReservaDto> consultarT();
    ReservaDto findDtoById(Long id);
}
