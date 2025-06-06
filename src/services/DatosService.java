package services;

import models.DatosMaestros;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatosService {

    public List<DatosMaestros> getAllDatos() {
        List<DatosMaestros> lista = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM datos_maestros";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                lista.add(new DatosMaestros(
                        rs.getInt("id"),
                        rs.getString("descripcion"),
                        rs.getString("estado")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean insertDato(DatosMaestros dato) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO datos_maestros (descripcion, estado) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, dato.getDescripcion());
            stmt.setString(2, dato.getEstado());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateDato(DatosMaestros dato) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "UPDATE datos_maestros SET descripcion = ?, estado = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, dato.getDescripcion());
            stmt.setString(2, dato.getEstado());
            stmt.setInt(3, dato.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteDato(int id) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "DELETE FROM datos_maestros WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}