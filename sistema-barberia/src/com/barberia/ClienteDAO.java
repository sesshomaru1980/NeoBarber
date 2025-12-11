package com.barberia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void insertarCliente(String nombre, String telefono, String email) {
        String sql = "INSERT INTO clientes (nombre, telefono, email, fecha_registro) VALUES (?, ?, ?, CURDATE())";
        try (Connection conn = DatabaseConnection.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, telefono);
            pstmt.setString(3, email);
            pstmt.executeUpdate();
            System.out.println("✅ Cliente insertado: " + nombre);
        } catch (SQLException e) {
            System.err.println("❌ Error insertar: " + e.getMessage());
        }
    }

    public List<String> listarClientes() {
        List<String> clientes = new ArrayList<>();
        String sql = "SELECT id_cliente, nombre, telefono, email FROM clientes";
        try (Connection conn = DatabaseConnection.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                clientes.add(rs.getInt("id_cliente") + ": " + rs.getString("nombre") +
                        " - " + rs.getString("telefono"));
            }
        } catch (SQLException e) {
            System.err.println("❌ Error listar: " + e.getMessage());
        }
        return clientes;
    }

    public void actualizarCliente(int id, String nombre, String telefono, String email) {
        String sql = "UPDATE clientes SET nombre=?, telefono=?, email=? WHERE id_cliente=?";
        try (Connection conn = DatabaseConnection.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, telefono);
            pstmt.setString(3, email);
            pstmt.setInt(4, id);
            int filas = pstmt.executeUpdate();
            if (filas > 0) {
                System.out.println("✅ Cliente actualizado ID: " + id);
            }
        } catch (SQLException e) {
            System.err.println("❌ Error actualizar: " + e.getMessage());
        }
    }

    public void eliminarCliente(int id) {
        String sql = "DELETE FROM clientes WHERE id_cliente=?";
        try (Connection conn = DatabaseConnection.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int filas = pstmt.executeUpdate();
            if (filas > 0) {
                System.out.println("✅ Cliente eliminado ID: " + id);
            }
        } catch (SQLException e) {
            System.err.println("❌ Error eliminar: " + e.getMessage());
        }
    }
}
