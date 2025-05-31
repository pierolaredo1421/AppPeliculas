package pe.edu.usil.repository.impl;

import pe.edu.usil.model.Usuario;
import pe.edu.usil.repository.UsuarioRepository;
import java.util.*;

public class InMemoryUsuarioRepository implements UsuarioRepository {
    private final Map<Long, Usuario> usuarios = new HashMap<>();
    private long nextId = 1L;

    @Override
    public void guardar(Usuario usuario) {
        usuario.setId(nextId++);
        usuarios.put(usuario.getId(), usuario);
    }

    @Override
    public void actualizar(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
    }

    @Override
    public void eliminarPorId(Long id) {
        usuarios.remove(id);
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return usuarios.get(id);
    }

    @Override
    public List<Usuario> listar() {
        return new ArrayList<>(usuarios.values());
    }

    @Override
    public boolean existePorCorreo(String correo) {
        return usuarios.values().stream()
                .anyMatch(u -> u.getCorreo().equalsIgnoreCase(correo));
    }

    @Override
    public boolean existePorId(Long id) {
        return usuarios.containsKey(id);
    }
}