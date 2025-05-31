package pe.edu.usil.service;

import pe.edu.usil.model.Usuario;
import pe.edu.usil.repository.UsuarioRepository;
import java.util.List;

public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void registrarUsuario(Usuario usuario) {
        if (usuario.getCorreo() == null || usuario.getCorreo().isBlank()) {
            throw new IllegalArgumentException("El correo no puede estar vacío.");
        }
        if (usuarioRepository.existePorCorreo(usuario.getCorreo())) {
            throw new IllegalArgumentException("Ya existe un usuario con este correo.");
        }
        usuarioRepository.guardar(usuario);
    }

    public void actualizarUsuario(Usuario usuario) {
        usuarioRepository.actualizar(usuario);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.eliminarPorId(id);
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.buscarPorId(id);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.listar();
    }
}