package pe.edu.usil.view;

import pe.edu.usil.controller.UsuarioController;

import javax.swing.*;
import java.awt.*;

public class RegistroView extends JFrame {
    private JTextField txtNombre, txtCorreo;
    private JPasswordField txtPassword;
    private UsuarioController usuarioController = new UsuarioController();

    public RegistroView() {
        setTitle("Registrarse - FilmoTeca");
        setSize(400, 260);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel lblTitulo = new JLabel("Registrarse");
        lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2; gbc.insets = new Insets(10,10,10,10);
        add(lblTitulo, gbc);

        gbc.gridwidth = 1; gbc.anchor = GridBagConstraints.WEST;
        gbc.gridy++;
        add(new JLabel("Nombre y apellidos:"), gbc);
        txtNombre = new JTextField(20);
        gbc.gridx = 1;
        add(txtNombre, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Correo:"), gbc);
        txtCorreo = new JTextField(20);
        gbc.gridx = 1;
        add(txtCorreo, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Contraseña:"), gbc);
        txtPassword = new JPasswordField(20);
        gbc.gridx = 1;
        add(txtPassword, gbc);

        JButton btnCrear = new JButton("Crear Usuario");
        gbc.gridx = 1; gbc.gridy++; gbc.anchor = GridBagConstraints.CENTER;
        add(btnCrear, gbc);

        btnCrear.addActionListener(e -> registrarUsuario());
    }

    private void registrarUsuario() {
        String nombre = txtNombre.getText();
        String correo = txtCorreo.getText();
        String password = new String(txtPassword.getPassword());
        try {
            usuarioController.registrarUsuario(nombre, correo, password);
            JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente.");
            new LoginView().setVisible(true);
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}