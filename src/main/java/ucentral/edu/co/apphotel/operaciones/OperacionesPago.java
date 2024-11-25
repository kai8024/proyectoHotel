package ucentral.edu.co.apphotel.operaciones;

import ucentral.edu.co.apphotel.dto.PagoDto;

import java.util.List;

public interface OperacionesPago {
    void crear(PagoDto pago);
    public List<PagoDto> consultarP();
    PagoDto findDtoById(Long id);
}
