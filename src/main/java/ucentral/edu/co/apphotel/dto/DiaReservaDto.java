package ucentral.edu.co.apphotel.dto;

import lombok.*;
import ucentral.edu.co.apphotel.entidades.Reserva;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class DiaReservaDto {
    private Long id;
    private LocalDate fecha;
    private Reserva reserva;
}
