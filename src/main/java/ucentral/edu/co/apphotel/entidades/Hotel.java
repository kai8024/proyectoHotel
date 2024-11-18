package ucentral.edu.co.apphotel.entidades;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Hotel")
@Table(name = "HOTELES")
@Builder
@ToString

public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "HOT_ID", nullable = false)
    private long id;

    @Column(name = "HOT_NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "HOT_SITIOS", nullable = false)
    private String sitios;

    @Column(name = "HOT_DIRECCION", nullable = false)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "RES_HOTEL")
    private Reserva reserva;
}
