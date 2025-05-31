package pe.edu.usil.view;

import pe.edu.usil.controller.PeliculaController;

import javax.swing.*;
import java.awt.*;

public class RegistrarPeliculaView extends JFrame {
    private JTextField txtTitulo, txtAutor, txtValoracion, txtAnio;
    private JComboBox<String> cmbGenero;
    private PeliculaController peliculaController = new PeliculaController();
    private PrincipalView principalView;

    public RegistrarPeliculaView(PrincipalView principalView) {
        this.principalView = principalView;

        setTitle("Registrar Película");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(6,6,6,6);
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Título:"), gbc);
        txtTitulo = new JTextField(18);
        gbc.gridx = 1;
        add(txtTitulo, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Autor (opcional):"), gbc);
        txtAutor = new JTextField(18);
        gbc.gridx = 1;
        add(txtAutor, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Valoración (opcional):"), gbc);
        txtValoracion = new JTextField(18);
        gbc.gridx = 1;
        add(txtValoracion, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Año de lanzamiento:"), gbc);
        txtAnio = new JTextField(18);
        gbc.gridx = 1;
        add(txtAnio, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Género:"), gbc);
        cmbGenero = new JComboBox<>(new String[]{"Acción", "Drama", "Comedia", "Terror", "Otro"});
        gbc.gridx = 1;
        add(cmbGenero, gbc);

        JButton btnConfirmar = new JButton("Confirmar");
        gbc.gridx = 1; gbc.gridy++;
        add(btnConfirmar, gbc);

        btnConfirmar.addActionListener(e -> registrarPelicula());
    }

    private void registrarPelicula() {
        String titulo = txtTitulo.getText();
        String autor = txtAutor.getText();
        String valoracion = txtValoracion.getText();
        String anioStr = txtAnio.getText();
        String genero = cmbGenero.getSelectedItem().toString();

        try {
            int anio = Integer.parseInt(anioStr);
            double calificacion = valoracion.isEmpty() ? 0.0 : Double.parseDouble(valoracion);
            peliculaController.registrarPelicula(titulo, autor, anio, genero, calificacion);
            JOptionPane.showMessageDialog(this, "Película registrada.");
            principalView.recargarPeliculas();
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Datos inválidos: " + ex.getMessage());
        }
    }
}