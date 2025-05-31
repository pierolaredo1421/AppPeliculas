package pe.edu.usil.repository;

import pe.edu.usil.model.Usuario;
import java.util.List;

public interface UsuarioRepository {
    void guardar(Usuario usuario);
    void actualizar(Usuario usuario);
    void eliminarPorId(Long id);
    Usuario buscarPorId(Long id);
    List<Usuario> listar();
    boolean existePorCorreo(String correo);
    boolean existePorId(Long id);
}