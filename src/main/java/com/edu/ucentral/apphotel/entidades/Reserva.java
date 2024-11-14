package com.edu.ucentral.apphotel.entidades;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Reserva")
@Table(name = "RESARVAS")
@Builder
@ToString

public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "RES_ID", nullable = false)
    private long id;

    @Column(name = "RES_NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "RES_IDENTIFICACION", nullable = false)
    private int identificacion;

    @Column(name = "RES_CORREO", nullable = false)
    private String correo;

    @Column(name = "RES_TELEFONO", nullable = false)
    private int telefono;

    @Column(name = "RES_ENTRADA", nullable = false)
    private String entrada;

    @Column(name = "RES_SALIDA", nullable = false)
    private String salida;

    @Column(name = "RES_HABITACION", nullable = false)
    private String Habitacion;

    @Column(name = "RES_ADULTOS", nullable = false)
    private int adultos;

    @Column(name = "RES_MENORES", nullable = false)
    private int menores;




}
