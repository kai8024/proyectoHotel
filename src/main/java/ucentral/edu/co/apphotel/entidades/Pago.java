package ucentral.edu.co.apphotel.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Pago")
@Table(name = "PAGOS")
@Builder
@ToString
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "PAG_ID", nullable = false)
    private long id;

    @Column(name = "PAG_NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "PAG_NUMERO", nullable = false)
    private int numero;

    @Column(name = "PAG_VENCIMIENTO", nullable = false)
    private String vencimiento;

    @Column(name = "PAG_CODIGO", nullable = false)
    private int codigo;

    @Column(name = "PAG_MONTO", nullable = false)
    private Long monto;

    @ManyToOne
    @JoinColumn(name = "RES_ID")
    private Reserva reserva;

}
