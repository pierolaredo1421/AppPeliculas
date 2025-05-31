package pe.edu.usil.view;

import pe.edu.usil.view.SeleccionInicioView;

import javax.swing.*;
import java.awt.*;

public class BienvenidaView extends JFrame {
    public BienvenidaView() {
        setTitle("FilmoTeca");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel lblTitulo = new JLabel("FilmoTeca", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
        add(lblTitulo);

        Timer timer = new Timer(2000, e -> {
            new SeleccionInicioView().setVisible(true);
            dispose();
        });
        timer.setRepeats(false);
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BienvenidaView().setVisible(true));
    }
}