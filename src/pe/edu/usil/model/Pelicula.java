package pe.edu.usil.model;

import java.io.Serializable;

public class Pelicula implements Serializable {
    private Long id;
    private String titulo;
    private String director;
    private int anio;
    private String genero;
    private double calificacion;

    public Pelicula() {}

    public static class Builder {
        private Long id;
        private String titulo;
        private String director;
        private int anio;
        private String genero;
        private double calificacion;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder titulo(String titulo) { this.titulo = titulo; return this; }
        public Builder director(String director) { this.director = director; return this; }
        public Builder anio(int anio) { this.anio = anio; return this; }
        public Builder genero(String genero) { this.genero = genero; return this; }
        public Builder calificacion(double calificacion) { this.calificacion = calificacion; return this; }
        public Pelicula build() {
            Pelicula p = new Pelicula();
            p.id = id;
            p.titulo = titulo;
            p.director = director;
            p.anio = anio;
            p.genero = genero;
            p.calificacion = calificacion;
            return p;
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }
    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public double getCalificacion() { return calificacion; }
    public void setCalificacion(double calificacion) { this.calificacion = calificacion; }
}