package pe.edu.usil.view;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    public LoginView() {
        setTitle("Iniciar sesión - FilmoTeca");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel lblTitulo = new JLabel("Iniciar sesión");
        lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2; gbc.insets = new Insets(10,10,15,10);
        panel.add(lblTitulo, gbc);

        JLabel lblCorreo = new JLabel("Usuario / Correo:");
        gbc.gridwidth = 1; gbc.anchor = GridBagConstraints.WEST; gbc.gridx = 0; gbc.gridy = 1; gbc.insets = new Insets(5,10,5,5);
        panel.add(lblCorreo, gbc);

        JTextField txtCorreo = new JTextField(18); // tamaño suficiente
        gbc.gridx = 1; gbc.gridy = 1; gbc.insets = new Insets(5,5,5,10);
        panel.add(txtCorreo, gbc);

        JLabel lblPass = new JLabel("Contraseña:");
        gbc.gridx = 0; gbc.gridy = 2; gbc.insets = new Insets(5,10,5,5);
        panel.add(lblPass, gbc);

        JPasswordField txtPassword = new JPasswordField(18);
        gbc.gridx = 1; gbc.gridy = 2; gbc.insets = new Insets(5,5,5,10);
        panel.add(txtPassword, gbc);

        JButton btnSiguiente = new JButton("Siguiente");
        gbc.gridx = 1; gbc.gridy = 3; gbc.anchor = GridBagConstraints.CENTER; gbc.insets = new Insets(15,5,10,10);
        panel.add(btnSiguiente, gbc);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginView().setVisible(true));
    }
}