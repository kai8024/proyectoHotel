package com.edu.ucentral.apphotel.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
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

    @Column(name = "HAB_TIPO", nullable = false)
    private String tipo;

    @Column(name = "HAB_TARIFA", nullable = false)
    private long tarifa;

    @Column(name = "HAB_ESTADO", nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "HOT_ID")
    private Hotel hotel;
}
