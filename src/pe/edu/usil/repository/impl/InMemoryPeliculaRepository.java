package pe.edu.usil.repository.impl;

import pe.edu.usil.model.Pelicula;
import pe.edu.usil.repository.PeliculaRepository;
import java.util.*;

public class InMemoryPeliculaRepository implements PeliculaRepository {
    private final Map<Long, Pelicula> peliculas = new HashMap<>();
    private long nextId = 1L;

    @Override
    public void guardar(Pelicula pelicula) {
        pelicula.setId(nextId++);
        peliculas.put(pelicula.getId(), pelicula);
    }

    @Override
    public void actualizar(Pelicula pelicula) {
        peliculas.put(pelicula.getId(), pelicula);
    }

    @Override
    public void eliminarPorId(Long id) {
        peliculas.remove(id);
    }

    @Override
    public Pelicula buscarPorId(Long id) {
        return peliculas.get(id);
    }

    @Override
    public List<Pelicula> listar() {
        return new ArrayList<>(peliculas.values());
    }

    @Override
    public boolean existePorTitulo(String titulo) {
        return peliculas.values().stream()
                .anyMatch(p -> p.getTitulo().equalsIgnoreCase(titulo));
    }

    @Override
    public boolean existePorId(Long id) {
        return peliculas.containsKey(id);
    }
}