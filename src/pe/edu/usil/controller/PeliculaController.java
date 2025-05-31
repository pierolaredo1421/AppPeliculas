package pe.edu.usil.controller;

import pe.edu.usil.facade.PeliculaFacade;
import pe.edu.usil.factory.ServiceFactory;
import pe.edu.usil.model.Pelicula;
import java.util.List;

public class PeliculaController {
    private final PeliculaFacade facade;

    public PeliculaController() {
        this.facade = ServiceFactory.crearPeliculaFacade();
    }

    public void registrarPelicula(String titulo, String director, int anio, String genero, double calificacion) {
        Pelicula pelicula = new Pelicula.Builder()
                .titulo(titulo)
                .director(director)
                .anio(anio)
                .genero(genero)
                .calificacion(calificacion)
                .build();
        facade.registrarPelicula(pelicula);
    }

    public void eliminarPelicula(Long id) {
        facade.eliminarPelicula(id);
    }

    public List<Pelicula> listarPeliculas() {
        return facade.listarPeliculas();
    }

    public Pelicula buscarPeliculaPorId(Long id) {
        return facade.buscarPeliculaPorId(id);
    }
}