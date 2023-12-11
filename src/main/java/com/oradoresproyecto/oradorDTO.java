package com.oradoresproyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class oradorDTO {

	private static final String BD_Conexion =  "jdbc:mysql://localhost:3306/bd_oradores";
	private static final String Usuario_BD = "root";
	private static final String Contrasena_BD = "Max_mysql07";

    public void saveOrador(String nombre, String apellido, String tematica, String fecha) {
        try (Connection con = DriverManager.getConnection(BD_Conexion, Usuario_BD, Contrasena_BD);
            Statement stmt = con.createStatement()) {
            //String query = "INSERT INTO bd_oradores.orador(nombre, apellido, tematica, fecha) VALUES (?, ?, ?, ?)";
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al intentar guardar el orador en la base de datos");
        }
    }

    public ArrayList<orador> getOradora() {
        oradorMapping oradorMapping = new oradorMapping();
        ArrayList<orador> oradores = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(BD_Conexion, Usuario_BD, Contrasena_BD);
            Statement stmt = con.createStatement()) {
            System.out.println("Se conectó a la base de datos");
            String query = "SELECT * FROM orador;";
            try (ResultSet result = stmt.executeQuery(query)) {
                System.out.println("Se ejecutó correctamente la consulta SQL");
                while (result.next()) {
                    String nombreBD = result.getString("nombre");
                    String apellidoBD = result.getString("apellido");
                    String tematicaBD = result.getString("tematica");
                    String fechaBD = result.getString("fecha");
                    oradores.add(oradorMapping.mapOrador(nombreBD, apellidoBD, tematicaBD, fechaBD));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al intentar obtener los oradores desde la base de datos. Detalles: " + e.getMessage());
        }
        
        return oradores;
    }
}