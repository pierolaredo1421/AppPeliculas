package pe.edu.usil.repository;

import pe.edu.usil.model.Pelicula;
import java.util.List;

public interface PeliculaRepository {
    void guardar(Pelicula pelicula);
    void actualizar(Pelicula pelicula);
    void eliminarPorId(Long id);
    Pelicula buscarPorId(Long id);
    List<Pelicula> listar();
    boolean existePorTitulo(String titulo);
    boolean existePorId(Long id);
}