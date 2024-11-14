package com.edu.ucentral.apphotel.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class HabitacionDto implements Serializable{
    private long id;
    private String tipo;
    private long tarifa;
    private String estado;
}
