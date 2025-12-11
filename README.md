# Neobarber - Sistema de Citas para Barbería

**Neobarber** es una aplicación de sistema de citas para una barbería. Permite gestionar a los clientes, barberos y citas de forma eficiente. Los usuarios pueden realizar, consultar, actualizar y cancelar citas con sus barberos favoritos.

## Características

- **Gestión de clientes**: Los clientes pueden ser registrados, actualizados, consultados y eliminados.
- **Gestión de barberos**: Los barberos pueden ser registrados, actualizados, consultados y eliminados.
- **Gestión de citas**: Los clientes pueden realizar citas, que se asignan a un barbero, y pueden ser consultadas, actualizadas y eliminadas.
- **Interfaz sencilla**: Basada en la terminal (línea de comandos) para facilitar la interacción.

## Tecnologías

- **Java 11+** (programación orientada a objetos).
- **JDBC** (Java Database Connectivity) para la conexión con la base de datos.
- **MySQL** como sistema de gestión de bases de datos.
- **Maven** como gestor de dependencias.

## Requisitos previos

Antes de comenzar, asegúrate de tener instalados los siguientes requisitos:

- **Java 11+**: [Descargar Java](https://adoptopenjdk.net/)
- **MySQL**: [Descargar MySQL](https://dev.mysql.com/downloads/installer/)
- **IntelliJ IDEA** (opcional, pero recomendado): [Descargar IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
- **Maven**: [Descargar Maven](https://maven.apache.org/download.cgi) (si no tienes Maven integrado en IntelliJ IDEA)

## Configuración

### Paso 1: Crear la base de datos en MySQL

1. Abre **MySQL Workbench** y conéctate a tu servidor MySQL.
2. Ejecuta los siguientes comandos para crear la base de datos y las tablas:

   ```sql
   CREATE DATABASE neobarberDB;
   USE neobarberDB;

   CREATE TABLE clientes (
       id_cliente INT AUTO_INCREMENT PRIMARY KEY,
       nombre_cliente VARCHAR(255) NOT NULL,
       telefono_cliente VARCHAR(20) NOT NULL,
       correo_cliente VARCHAR(255),
       fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
   );

   CREATE TABLE barberos (
       id_barbero INT AUTO_INCREMENT PRIMARY KEY,
       nombre_barbero VARCHAR(255) NOT NULL,
       especialidad VARCHAR(255),
       fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
   );

   CREATE TABLE citas (
       id_cita INT AUTO_INCREMENT PRIMARY KEY,
       id_cliente INT,
       id_barbero INT,
       fecha_cita DATETIME NOT NULL,
       servicio VARCHAR(255),
       estado_cita ENUM('pendiente', 'completada', 'cancelada') DEFAULT 'pendiente',
       fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
       FOREIGN KEY (id_barbero) REFERENCES barberos(id_barbero)
   );
