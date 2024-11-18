package ucentral.edu.co.apphotel.dto;

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
public class UsuarioDto implements Serializable {
    private long id;
    private String nombre;
    private String correo;
    private String contrasena;
}
