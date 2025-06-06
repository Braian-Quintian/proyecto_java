package ui;

import models.Usuario;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DashboardPanel extends JPanel {
    public DashboardPanel(Usuario usuario) {
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Bienvenido al Sistema", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        JPanel center = new JPanel(new GridLayout(4, 1));
        center.add(new JLabel("Usuario: " + usuario.getNombreUsuario(), SwingConstants.CENTER));
        center.add(new JLabel("Rol: " + usuario.getRol(), SwingConstants.CENTER));

        String fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        center.add(new JLabel("Fecha y hora actual: " + fechaHora, SwingConstants.CENTER));

        ImageIcon icon = new ImageIcon("logo.png");
        JLabel logo = new JLabel(icon, SwingConstants.CENTER);
        center.add(logo);

        add(center, BorderLayout.CENTER);
    }
}