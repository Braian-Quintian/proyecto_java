package ui;

import models.Usuario;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainMenu extends JFrame {
    private Usuario usuarioActual;
    private JPanel mainPanel;

    public MainMenu(Usuario usuario) {
        this.usuarioActual = usuario;
        setTitle("Menú Principal - Proyecto UTS");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initMenu();
        initMainPanel();
    }

    private void initMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuInicio = new JMenu("Inicio");
        JMenu menuMantenimiento = new JMenu("Mantenimiento");
        JMenu menuConfig = new JMenu("Configuración");
        JMenu menuSalir = new JMenu("Salir");

        JMenuItem itemInicio = new JMenuItem("Pantalla Inicial");
        JMenuItem itemDatos = new JMenuItem("Datos Maestros");
        JMenuItem itemUsuarios = new JMenuItem("Usuarios");
        JMenuItem itemCambiarClave = new JMenuItem("Cambiar Clave");
        JMenuItem itemSalir = new JMenuItem("Cerrar Sesión");

        itemInicio.addActionListener(e -> setMainPanel(new DashboardPanel(usuarioActual)));
        itemDatos.addActionListener(e -> setMainPanel(new CrudDatosPanel()));
        itemUsuarios.addActionListener(e -> setMainPanel(new CrudUsuariosPanel()));
        itemCambiarClave.addActionListener(e -> JOptionPane.showMessageDialog(this, "Funcionalidad pendiente"));

        itemSalir.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Hasta luego " + usuarioActual.getNombreUsuario());
            new LoginForm().setVisible(true);
            dispose();
        });

        menuInicio.add(itemInicio);
        menuMantenimiento.add(itemDatos);
        if (usuarioActual.getRol().equalsIgnoreCase("admin")) {
            menuConfig.add(itemUsuarios);
        }
        menuConfig.add(itemCambiarClave);
        menuSalir.add(itemSalir);

        menuBar.add(menuInicio);
        menuBar.add(menuMantenimiento);
        menuBar.add(menuConfig);
        menuBar.add(menuSalir);
        setJMenuBar(menuBar);
    }

    private void initMainPanel() {
        mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);
        setMainPanel(new DashboardPanel(usuarioActual));
    }

    private void setMainPanel(JPanel panel) {
        mainPanel.removeAll();
        mainPanel.add(panel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}