package com.edu.ucentral.apphotel.entidades;

import lombok.*;

import javax.persistence.*;

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

    @Column(name = "USU_CORREO", nullable = false)
    private String correo;

    @Column(name = "USU_TELEFONO", nullable = false)
    private int telefono;

}
