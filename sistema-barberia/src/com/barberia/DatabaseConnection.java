package com.barberia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/barberia?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";  // Cambiar por tu usuario
    private static final String PASSWORD = "6162912";     // Cambiar por tu contraseña

    public static Connection obtenerConexion() {
        try {
            Connection conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("✅ Conexión exitosa a la base de datos");
            return conexion;
        } catch (SQLException e) {
            System.err.println("❌ Error conexión: " + e.getMessage());
            return null;
        }
    }
}
