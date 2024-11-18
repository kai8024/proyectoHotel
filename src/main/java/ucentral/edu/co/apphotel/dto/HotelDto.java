package ucentral.edu.co.apphotel.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class HotelDto implements Serializable {
    private long id;
    private String nombre;
    private String sitios;
    private String direccion;

}
