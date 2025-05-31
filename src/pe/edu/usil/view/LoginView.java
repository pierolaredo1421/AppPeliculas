package pe.edu.usil.view;

import pe.edu.usil.controller.UsuarioController;
import pe.edu.usil.model.Usuario;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    public LoginView() {
        setTitle("Iniciar sesión - FilmoTeca");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        UsuarioController usuarioController = new UsuarioController();

        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints gbcTitulo = new GridBagConstraints();
        gbcTitulo.gridx = 0; gbcTitulo.gridy = 0; gbcTitulo.gridwidth = 2;
        gbcTitulo.insets = new Insets(10,10,15,10);
        JLabel lblTitulo = new JLabel("Iniciar sesión");
        lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        panel.add(lblTitulo, gbcTitulo);

        GridBagConstraints gbcLblCorreo = new GridBagConstraints();
        gbcLblCorreo.gridx = 0; gbcLblCorreo.gridy = 1;
        gbcLblCorreo.anchor = GridBagConstraints.EAST;
        gbcLblCorreo.insets = new Insets(5,10,5,5);
        panel.add(new JLabel("Usuario / Correo:"), gbcLblCorreo);

        GridBagConstraints gbcTxtCorreo = new GridBagConstraints();
        gbcTxtCorreo.gridx = 1; gbcTxtCorreo.gridy = 1;
        gbcTxtCorreo.fill = GridBagConstraints.HORIZONTAL;
        gbcTxtCorreo.weightx = 1.0;
        gbcTxtCorreo.insets = new Insets(5,5,5,10);
        JTextField txtCorreo = new JTextField(18);
        panel.add(txtCorreo, gbcTxtCorreo);

        GridBagConstraints gbcLblPass = new GridBagConstraints();
        gbcLblPass.gridx = 0; gbcLblPass.gridy = 2;
        gbcLblPass.anchor = GridBagConstraints.EAST;
        gbcLblPass.insets = new Insets(5,10,5,5);
        panel.add(new JLabel("Contraseña:"), gbcLblPass);

        GridBagConstraints gbcTxtPass = new GridBagConstraints();
        gbcTxtPass.gridx = 1; gbcTxtPass.gridy = 2;
        gbcTxtPass.fill = GridBagConstraints.HORIZONTAL;
        gbcTxtPass.weightx = 1.0;
        gbcTxtPass.insets = new Insets(5,5,5,10);
        JPasswordField txtPassword = new JPasswordField(18);
        panel.add(txtPassword, gbcTxtPass);

        GridBagConstraints gbcBtn = new GridBagConstraints();
        gbcBtn.gridx = 1; gbcBtn.gridy = 3;
        gbcBtn.anchor = GridBagConstraints.CENTER;
        gbcBtn.insets = new Insets(15,5,10,10);
        JButton btnSiguiente = new JButton("Siguiente");
        panel.add(btnSiguiente, gbcBtn);

        add(panel, BorderLayout.CENTER);

        btnSiguiente.addActionListener(e -> {
            String correo = txtCorreo.getText().trim();
            String password = new String(txtPassword.getPassword());
            Usuario usuario = usuarioController.login(correo, password);
            if (usuario != null) {
                new PrincipalView(usuario).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Usuario/correo o contraseña incorrectos");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginView().setVisible(true));
    }
}