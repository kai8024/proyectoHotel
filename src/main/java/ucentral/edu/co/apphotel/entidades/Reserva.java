package ucentral.edu.co.apphotel.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Reserva")
@Table(name = "RESERVAS")
@Builder
@ToString

public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "RES_ID", nullable = false)
    private long id;

    @Column(name = "RES_HOTEL", nullable = false)
    private String hotel;

    @Column(name = "RES_NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "RES_IDENTIFICACION", nullable = false)
    private int identificacion;

    @Column(name = "RES_CORREO", nullable = false)
    private String correo;

    @Column(name = "RES_TELEFONO", nullable = false)
    private Long telefono;

    @Column(name = "RES_HABITACION", nullable = false)
    private Long habitacion;

    @Column(name = "RES_ENTRADA", nullable = false)
    private LocalDate entrada;

    @Column(name = "RES_SALIDA", nullable = false)
    private LocalDate salida;

    @Column(name = "RES_ADULTOS", nullable = false)
    private int adultos;

    @Column(name = "RES_MENORES", nullable = false)
    private int menores;

    @Column(name = "RES_DIAS", nullable = false)
    private int dias;

}
