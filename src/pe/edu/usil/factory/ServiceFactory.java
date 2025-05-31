package pe.edu.usil.factory;

import pe.edu.usil.facade.PeliculaFacade;
import pe.edu.usil.facade.UsuarioFacade;
import pe.edu.usil.repository.UsuarioRepository;
import pe.edu.usil.repository.impl.InMemoryUsuarioRepository;
import pe.edu.usil.repository.PeliculaRepository;
import pe.edu.usil.repository.impl.InMemoryPeliculaRepository;
import pe.edu.usil.service.UsuarioService;
import pe.edu.usil.service.PeliculaService;

public class ServiceFactory {
    private static UsuarioService usuarioService;
    private static PeliculaService peliculaService;

    public static UsuarioService crearUsuarioService() {
        if (usuarioService == null) {
            UsuarioRepository repo = new InMemoryUsuarioRepository();
            usuarioService = new UsuarioService(repo);
        }
        return usuarioService;
    }

    public static PeliculaService crearPeliculaService() {
        if (peliculaService == null) {
            PeliculaRepository repo = new InMemoryPeliculaRepository();
            peliculaService = new PeliculaService(repo);
        }
        return peliculaService;
    }

    public static UsuarioRepository crearUsuarioRepository() {
        return new InMemoryUsuarioRepository();
    }

    public static PeliculaRepository crearPeliculaRepository() {
        return new InMemoryPeliculaRepository();
    }

    public static UsuarioFacade crearUsuarioFacade() {
        return new UsuarioFacade();
    }

    public static PeliculaFacade crearPeliculaFacade() {
        return new PeliculaFacade();
    }
}