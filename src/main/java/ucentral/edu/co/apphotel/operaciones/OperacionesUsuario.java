package ucentral.edu.co.apphotel.operaciones;


import ucentral.edu.co.apphotel.dto.UsuarioDto;
import ucentral.edu.co.apphotel.entidades.Usuario;

import java.util.List;

public interface OperacionesUsuario {
    void crearL(UsuarioDto usuario);
    public List<UsuarioDto> consultarL();
    UsuarioDto findDtoByEmail(String correo);
}
