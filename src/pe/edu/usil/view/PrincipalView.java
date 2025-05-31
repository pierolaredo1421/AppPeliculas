package pe.edu.usil.view;

import pe.edu.usil.controller.PeliculaController;
import pe.edu.usil.model.Pelicula;
import pe.edu.usil.model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PrincipalView extends JFrame {
    private JTextField txtBuscar;
    private JComboBox<String> cmbGenero;
    private JPanel panelPeliculas;
    private PeliculaController peliculaController = new PeliculaController();
    private Usuario usuario;

    public PrincipalView(Usuario usuario) {
        this.usuario = usuario;

        setTitle("FilmoTeca - Catálogo");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnPerfil = new JButton("👤");
        cmbGenero = new JComboBox<>(new String[]{"Todo", "Acción", "Drama", "Comedia", "Terror", "Otro"});
        txtBuscar = new JTextField(20);
        JButton btnBuscar = new JButton("🔍");
        topBar.add(btnPerfil);
        topBar.add(cmbGenero);
        topBar.add(txtBuscar);
        topBar.add(btnBuscar);
        add(topBar, BorderLayout.NORTH);

        panelPeliculas = new JPanel();
        panelPeliculas.setLayout(new BoxLayout(panelPeliculas, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(panelPeliculas);
        add(scrollPane, BorderLayout.CENTER);

        JButton btnRegistrarPelicula = new JButton("Registrar Película");
        add(btnRegistrarPelicula, BorderLayout.SOUTH);

        btnRegistrarPelicula.addActionListener(e -> {
            new RegistrarPeliculaView(this).setVisible(true);
        });
        btnBuscar.addActionListener(e -> recargarPeliculas());
        cmbGenero.addActionListener(e -> recargarPeliculas());

        recargarPeliculas();
    }

    public void recargarPeliculas() {
        panelPeliculas.removeAll();
        String filtro = txtBuscar.getText().trim().toLowerCase();
        String genero = cmbGenero.getSelectedItem().toString();
        List<Pelicula> peliculas = peliculaController.listarPeliculas();
        for (Pelicula p : peliculas) {
            if (!filtro.isEmpty() && !p.getTitulo().toLowerCase().contains(filtro)) continue;
            if (!genero.equals("Todo") && !p.getGenero().equalsIgnoreCase(genero)) continue;

            JPanel panel = new JPanel(new BorderLayout());
            panel.add(new JLabel(p.getTitulo()), BorderLayout.CENTER);
            JButton btnEntrar = new JButton("Entrar");
            panel.add(btnEntrar, BorderLayout.EAST);
            btnEntrar.addActionListener(e -> new DetallePeliculaView(p).setVisible(true));
            panelPeliculas.add(panel);
        }
        panelPeliculas.revalidate();
        panelPeliculas.repaint();
    }
}