package pe.edu.usil.view;

import pe.edu.usil.model.Pelicula;

import javax.swing.*;
import java.awt.*;

public class DetallePeliculaView extends JFrame {
    public DetallePeliculaView(Pelicula pelicula) {
        setTitle("Detalle de Película");
        setSize(350, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0,1));

        add(new JLabel("Título: " + pelicula.getTitulo()));
        add(new JLabel("Año: " + pelicula.getAnio()));
        add(new JLabel("Género: " + pelicula.getGenero()));
        add(new JLabel("Autor: " + pelicula.getDirector()));
        add(new JLabel("Valoración: " + pelicula.getCalificacion()));

        JButton btnAtras = new JButton("Atrás");
        btnAtras.addActionListener(e -> dispose());
        add(btnAtras);
    }
}