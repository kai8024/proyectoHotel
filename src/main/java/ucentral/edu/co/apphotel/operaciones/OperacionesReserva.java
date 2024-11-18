package ucentral.edu.co.apphotel.operaciones;

import ucentral.edu.co.apphotel.dto.ReservaDto;

import java.util.List;

public interface OperacionesReserva {
    void crear(ReservaDto reserva);
    public List<ReservaDto> consultarT();
    ReservaDto findDtoById(Long id);
}
