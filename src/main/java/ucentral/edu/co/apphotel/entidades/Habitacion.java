package ucentral.edu.co.apphotel.entidades;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Habitacion")
@Table(name = "HABITACIONES")
@Builder
@ToString
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "HAB_ID", nullable = false)
    private long id;

    @Column(name = "HAB_NOMBRE", nullable = false)
    private String habitacion;
}
