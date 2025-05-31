package pe.edu.usil.controller;

import pe.edu.usil.facade.UsuarioFacade;
import pe.edu.usil.model.Usuario;
import java.util.List;

public class UsuarioController {
    private final UsuarioFacade facade = new UsuarioFacade();

    public Usuario login(String correo, String password) {
        List<Usuario> usuarios = facade.listarUsuarios();
        for (Usuario u : usuarios) {
            if (u.getCorreo().equalsIgnoreCase(correo) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    public void registrarUsuario(String nombreCompleto, String correo, String password) {
        Usuario usuario = new Usuario.Builder()
                .nombreCompleto(nombreCompleto)
                .correo(correo)
                .password(password)
                .build();
        facade.registrarUsuario(usuario);
    }

    public void eliminarUsuario(Long id) {
        facade.eliminarUsuario(id);
    }

    public List<Usuario> listarUsuarios() {
        return facade.listarUsuarios();
    }
}