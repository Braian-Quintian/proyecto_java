package ui;

import models.Usuario;
import services.UserService;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CrudUsuariosPanel extends JPanel {
    private UserService userService = new UserService();
    private JTable table;
    private DefaultListModel<String> listModel;

    public CrudUsuariosPanel() {
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Gestión de Usuarios", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(label, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        JList<String> userList = new JList<>(listModel);
        add(new JScrollPane(userList), BorderLayout.CENTER);

        JButton refreshBtn = new JButton("Actualizar");
        refreshBtn.addActionListener(e -> loadUsers());
        add(refreshBtn, BorderLayout.SOUTH);

        loadUsers();
    }

    private void loadUsers() {
        listModel.clear();
        List<Usuario> usuarios = userService.getAllUsers();
        for (Usuario u : usuarios) {
            listModel.addElement("ID: " + u.getId() + " | " + u.getNombreUsuario() + " | Rol: " + u.getRol());
        }
    }
}