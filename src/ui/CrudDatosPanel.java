package ui;

import models.DatosMaestros;
import services.DatosService;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CrudDatosPanel extends JPanel {
    private DatosService datosService = new DatosService();
    private DefaultListModel<String> listModel;

    public CrudDatosPanel() {
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Gestión de Datos Maestros", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(label, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        JList<String> datosList = new JList<>(listModel);
        add(new JScrollPane(datosList), BorderLayout.CENTER);

        JButton refreshBtn = new JButton("Actualizar");
        refreshBtn.addActionListener(e -> loadDatos());
        add(refreshBtn, BorderLayout.SOUTH);

        loadDatos();
    }

    private void loadDatos() {
        listModel.clear();
        List<DatosMaestros> datos = datosService.getAllDatos();
        for (DatosMaestros d : datos) {
            listModel.addElement("ID: " + d.getId() + " | " + d.getDescripcion() + " | Estado: " + d.getEstado());
        }
    }
}