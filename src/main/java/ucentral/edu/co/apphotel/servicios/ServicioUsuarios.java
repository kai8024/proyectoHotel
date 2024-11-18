package ucentral.edu.co.apphotel.servicios;

import ucentral.edu.co.apphotel.dto.UsuarioDto;
import ucentral.edu.co.apphotel.entidades.Usuario;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucentral.edu.co.apphotel.operaciones.OperacionesUsuario;
import ucentral.edu.co.apphotel.repositorios.RepoUsuario;
import java.util.List;

@Service
public class ServicioUsuarios implements OperacionesUsuario {
    @Autowired
    RepoUsuario repoUsuario;
    @Autowired
    ModelMapper modelMapper;

    public ServicioUsuarios(ModelMapper modelMapper, RepoUsuario repoUsuario) {
        this.modelMapper = modelMapper;
        this.repoUsuario = repoUsuario;
    }

    @Override
    public void crearL(UsuarioDto usuario){
        Usuario usuarios = modelMapper.map(usuario,Usuario.class);
        repoUsuario.save(usuarios);
    }

    @Override
    public List<UsuarioDto> consultarL() {
        TypeToken<List<UsuarioDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(repoUsuario.findAll(), typeToken.getType());
    }

    @Override
    public UsuarioDto findDtoByEmail(String correo) {
        Usuario usuario = repoUsuario.findById(correo).orElse(null);
        return usuario != null ? modelMapper.map(usuario, UsuarioDto.class) : null;
    }
}
