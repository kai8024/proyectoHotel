package ucentral.edu.co.apphotel.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class PagoDto implements Serializable {

    private Long id;
    private String nombre;
    private int numero;
    private String vencimiento;
    private int codigo;
    private long monto;


}
