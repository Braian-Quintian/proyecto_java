package app;

import ui.LoginForm;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Establecer el look and feel del sistema (opcional)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("No se pudo aplicar el look and feel: " + e.getMessage());
        }

        // Iniciar en hilo de interfaz gráfica
        SwingUtilities.invokeLater(() -> {
            new LoginForm().setVisible(true);
        });
    }
}