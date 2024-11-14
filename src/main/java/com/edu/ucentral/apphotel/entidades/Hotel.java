package com.edu.ucentral.apphotel.entidades;

import lombok.*;

import java.util.List;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Hotel")
@Table(name = "HOTELES")
@Builder
@ToString
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HOTELES")
    @SequenceGenerator(name = "SEQ_HOTELES", sequenceName = "SEQ_HOTELES", allocationSize = 1)


    @Column(name = "HOT_ID", nullable = false)
    private int id;

    @Column(name = "HOT_DIRECCION", nullable = false)
    private String direccion;

    @Column(name = "HOT_SITIOS", nullable = false)
    private String sitios;

}
