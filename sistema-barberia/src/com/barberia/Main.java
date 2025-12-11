package com.barberia;

public class Main {
    public static void main(String[] args) {
        ClienteDAO dao = new ClienteDAO();

        System.out.println("=== SISTEMA BARBERÍA - CRUD CLIENTES ===\n");

        // CREATE
        System.out.println("1. INSERTAR");
        dao.insertarCliente("María González", "3012345678", "maria@correo.com");

        // READ
        System.out.println("\n2. LISTAR");
        for (String cliente : dao.listarClientes()) {
            System.out.println("   " + cliente);
        }

        // UPDATE
        System.out.println("\n3. ACTUALIZAR");
        dao.actualizarCliente(1, "María González Ramírez", "3012345678", "maria.nueva@correo.com");

        // READ actualizado
        System.out.println("\n4. VER ACTUALIZADO");
        for (String cliente : dao.listarClientes()) {
            System.out.println("   " + cliente);
        }

        // DELETE (descomenta para probar)
        // System.out.println("\n5. ELIMINAR");
        // dao.eliminarCliente(1);
    }
}
