package pe.edu.usil.facade;

import pe.edu.usil.model.Pelicula;
import pe.edu.usil.service.PeliculaService;
import pe.edu.usil.factory.ServiceFactory;
import java.util.List;

public class PeliculaFacade {
    private final PeliculaService service = ServiceFactory.crearPeliculaService();

    public void registrarPelicula(Pelicula pelicula) {
        service.registrarPelicula(pelicula);
    }

    public void actualizarPelicula(Pelicula pelicula) {
        service.actualizarPelicula(pelicula);
    }

    public void eliminarPelicula(Long id) {
        service.eliminarPelicula(id);
    }

    public Pelicula buscarPeliculaPorId(Long id) {
        return service.buscarPeliculaPorId(id);
    }

    public List<Pelicula> listarPeliculas() {
        return service.listarPeliculas();
    }
}