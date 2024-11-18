package ucentral.edu.co.apphotel.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class HabitacionDto implements Serializable {
    private Long id;
    private String nombre;
}
