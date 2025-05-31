package pe.edu.usil.service;

import pe.edu.usil.model.Pelicula;
import pe.edu.usil.repository.PeliculaRepository;
import java.util.List;

public class PeliculaService {
    private final PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public void registrarPelicula(Pelicula pelicula) {
        if (pelicula.getTitulo() == null || pelicula.getTitulo().isBlank()) {
            throw new IllegalArgumentException("El título no puede estar vacío.");
        }
        if (peliculaRepository.existePorTitulo(pelicula.getTitulo())) {
            throw new IllegalArgumentException("Ya existe una película con este título.");
        }
        peliculaRepository.guardar(pelicula);
    }

    public void actualizarPelicula(Pelicula pelicula) {
        peliculaRepository.actualizar(pelicula);
    }

    public void eliminarPelicula(Long id) {
        peliculaRepository.eliminarPorId(id);
    }

    public Pelicula buscarPeliculaPorId(Long id) {
        return peliculaRepository.buscarPorId(id);
    }

    public List<Pelicula> listarPeliculas() {
        return peliculaRepository.listar();
    }
}