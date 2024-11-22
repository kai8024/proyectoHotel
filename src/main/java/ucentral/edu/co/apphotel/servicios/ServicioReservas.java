package ucentral.edu.co.apphotel.servicios;

import ucentral.edu.co.apphotel.dto.ReservaDto;
import ucentral.edu.co.apphotel.entidades.DiaReserva;
import ucentral.edu.co.apphotel.entidades.Reserva;
import ucentral.edu.co.apphotel.operaciones.OperacionesReserva;
import ucentral.edu.co.apphotel.repositorios.RepoDiaReserva;
import ucentral.edu.co.apphotel.repositorios.RepoReserva;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioReservas implements OperacionesReserva {
    @Autowired
    RepoReserva repoReserva;
    @Autowired
    ModelMapper modelMapper;

    public ServicioReservas(ModelMapper modelMapper, RepoReserva repoReserva) {
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

    private List<LocalDate> fechasReservadas = List.of(
            LocalDate.of(2024, 11, 16),
            LocalDate.of(2024, 11, 18),
            LocalDate.of(2024, 11, 20)
    );

    public List<Reserva> obtenerTodasReservas() {
        return repoReserva.findAll();
    }
    // Obtener las fechas reservadas
    public List<LocalDate> obtenerFechasReservadas() {
        return fechasReservadas;
    }
    /*public void guardarDiasReserva(List<LocalDate> dias, ReservaDto reservaDto) {
        // Convertir ReservaDto a Entidad Reserva (puedes adaptar esto según tu proyecto)
        Reserva reserva = convertirDtoAReserva(reservaDto);

        // Crear y guardar los días de reserva
        dias.forEach(dia -> {
            DiaReserva diaReserva = new DiaReserva();
            diaReserva.setFecha(dia);
            diaReserva.setReserva(reserva);
            RepoDiaReserva.save(diaReserva);
        });
    }*/

}
