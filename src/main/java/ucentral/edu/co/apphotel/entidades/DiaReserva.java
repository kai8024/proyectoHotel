package ucentral.edu.co.apphotel.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "DiaReserva")
@Table(name = "DIARESERVAS")
@Builder
@ToString
public class DiaReserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "DIA_ID", nullable = false)
    private long id;

    @Column(name = "DIA_FECHA", nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "RES_ID")
    private Reserva reserva;

    // Getters y Setters
}

