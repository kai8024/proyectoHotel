package ucentral.edu.co.apphotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.*;
import ucentral.edu.co.apphotel.entidades.Habitacion;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString

public class ReservaDto implements Serializable {
    private long id;
    private String hotel;
    private String nombre;
    private int identificacion;
    private String correo;
    private Long telefono;
    private Long habitacion;
    private LocalDate entrada;
    private LocalDate salida;
    private int adultos;
    private int menores;
    private LocalDate fechaReserva;
    private Long dias;
    private Long monto;

    public long calcularDiasEstadia() {
        if (entrada != null && salida != null) {
            return ChronoUnit.DAYS.between(entrada, salida);
        }
        return 0;
    }
}