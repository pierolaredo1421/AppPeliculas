package pe.edu.usil.view;

import javax.swing.*;
import java.awt.*;

public class SeleccionInicioView extends JFrame {
    public SeleccionInicioView() {
        setTitle("FilmoTeca");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel lblTitulo = new JLabel("FilmoTeca");
        lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2; gbc.insets = new Insets(10,10,20,10);
        add(lblTitulo, gbc);

        JButton btnLogin = new JButton("Iniciar sesión");
        JButton btnRegistro = new JButton("Registrarse");
        gbc.gridwidth = 1; gbc.gridy++;
        add(btnLogin, gbc);
        gbc.gridy++;
        add(btnRegistro, gbc);

        btnLogin.addActionListener(e -> {
            new LoginView().setVisible(true);
            dispose();
        });
        btnRegistro.addActionListener(e -> {
            new RegistroView().setVisible(true);
            dispose();
        });
    }
}