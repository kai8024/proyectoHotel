package ucentral.edu.co.apphotel.entidades;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Usuario")
@Table(name = "USUARIOS")
@Builder
@ToString

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "USU_ID", nullable = false)
    private long id;

    @Column(name = "USU_NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "RES_CORREO", nullable = false)
    private String correo;

    @Column(name = "USU_CONTRASENA", nullable = false)
    private String contrasena;
}
