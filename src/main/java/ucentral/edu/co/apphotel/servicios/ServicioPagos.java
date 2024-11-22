package ucentral.edu.co.apphotel.servicios;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucentral.edu.co.apphotel.dto.PagoDto;
import ucentral.edu.co.apphotel.dto.ReservaDto;
import ucentral.edu.co.apphotel.entidades.Pago;
import ucentral.edu.co.apphotel.entidades.Reserva;
import ucentral.edu.co.apphotel.operaciones.OperacionesPago;
import ucentral.edu.co.apphotel.repositorios.RepoPago;
import ucentral.edu.co.apphotel.repositorios.RepoReserva;

import java.util.List;

@Service
public class ServicioPagos implements OperacionesPago {
    @Autowired
    RepoPago repoPago;
    @Autowired
    ModelMapper modelMapper;

    public ServicioPagos(ModelMapper modelMapper, RepoPago repoPago) {
        this.modelMapper = modelMapper;
        this.repoPago = repoPago;
    }

    @Override
    public void crear(PagoDto pago) {
        Pago pagos = modelMapper.map(pago,Pago.class);
        repoPago.save(pagos);
    }

    @Override
    public List<PagoDto> consultarP() {
        TypeToken<List<PagoDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(repoPago.findAll(), typeToken.getType());
    }

    @Override
    public PagoDto findDtoById(Long id) {
        Pago pago = repoPago.findById(id).orElse(null);
        return pago != null ? modelMapper.map(pago, PagoDto.class) : null;
    }
}
