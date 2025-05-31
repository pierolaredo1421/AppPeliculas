package pe.edu.usil.facade;

import pe.edu.usil.model.Usuario;
import pe.edu.usil.service.UsuarioService;
import pe.edu.usil.factory.ServiceFactory;
import java.util.List;

public class UsuarioFacade {
    private final UsuarioService service = ServiceFactory.crearUsuarioService();

    public void registrarUsuario(Usuario usuario) {
        service.registrarUsuario(usuario);
    }

    public void actualizarUsuario(Usuario usuario) {
        service.actualizarUsuario(usuario);
    }

    public void eliminarUsuario(Long id) {
        service.eliminarUsuario(id);
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return service.buscarUsuarioPorId(id);
    }

    public List<Usuario> listarUsuarios() {
        return service.listarUsuarios();
    }
}