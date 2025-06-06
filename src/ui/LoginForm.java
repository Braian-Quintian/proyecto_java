package ui;

import models.Usuario;
import services.AuthService;

import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame {
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;
    private AuthService authService;

    public LoginForm() {
        authService = new AuthService();
        setTitle("Login - Proyecto UTS");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        userField = new JTextField();
        passField = new JPasswordField();
        loginButton = new JButton("Iniciar sesión");

        panel.add(new JLabel("Usuario:"));
        panel.add(userField);
        panel.add(new JLabel("Contraseña:"));
        panel.add(passField);
        panel.add(new JLabel());
        panel.add(loginButton);

        add(panel);

        loginButton.addActionListener(e -> {
            String usuario = userField.getText();
            String clave = new String(passField.getPassword());
            Usuario user = authService.login(usuario, clave);

            if (user != null) {
                JOptionPane.showMessageDialog(this, "Bienvenido " + user.getNombreUsuario());
                new MainMenu(user).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o clave incorrectos.");
            }
        });
    }
}