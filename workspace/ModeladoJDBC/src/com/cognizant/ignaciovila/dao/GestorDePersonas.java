package com.cognizant.ignaciovila.dao;

import com.cognizant.ignaciovila.bo.*;
import com.cognizant.ignaciovila.excepciones.MiExcepcion;

import java.io.*;
import java.sql.*;
import java.util.*;

public class GestorDePersonas {

    public void altaDePersona(Persona persona) throws MiExcepcion {
        Connection connection = null;
        try {
            connection = DBUtil.recuperarConeccion();
            String sql = "INSERT INTO persona (nombre, apellido, edad) values (?,?,?)";
            PreparedStatement comandoInsert = connection.prepareStatement(sql);
            comandoInsert.setString(1, persona.getNombre());
            comandoInsert.setString(2, persona.getApellido());
            comandoInsert.setInt(3, persona.getEdad());
            comandoInsert.execute();
        } catch (ClassNotFoundException e) {
            throw new MiExcepcion("Error de CLASE NO ENCONTRADA", e);
        } catch (SQLException e) {
            throw new MiExcepcion("Error SQL", e);
        }
    }

    public void actualizarPersona(Persona persona) throws MiExcepcion {
        Connection connection = null;
        try {
            connection = DBUtil.recuperarConeccion();
            String sql = "UPDATE persona SET nombre = ?, apellido = ?, edad = ? WHERE idPersona = ?";
            PreparedStatement comandoUpdate = connection.prepareStatement(sql);
            comandoUpdate.setString(1, persona.getNombre());
            comandoUpdate.setString(2, persona.getApellido());
            comandoUpdate.setInt(3, persona.getEdad());
            comandoUpdate.setInt(4, persona.getIdPersona());
            comandoUpdate.execute();
        } catch (ClassNotFoundException e) {
            throw new MiExcepcion("Error de CLASE NO ENCONTRADA", e);
        } catch (SQLException e) {
            throw new MiExcepcion("Error SQL", e);
        }
    }

    public Persona buscarPersonaPorId(int idPersona) throws MiExcepcion {
        Persona persona = null;
        Connection connection = null;
        try {
            connection = DBUtil.recuperarConeccion();
            String sql = "SELECT * from persona where idPersona = ?";
            PreparedStatement comandoBuscar = connection.prepareStatement(sql);
            comandoBuscar.setInt(1, idPersona);
            ResultSet resultado = comandoBuscar.executeQuery();
            if (resultado.next()) {
                persona = new Persona();
                persona.setNombre(resultado.getString("nombre"));
                persona.setApellido(resultado.getString("apellido"));
                persona.setEdad(resultado.getInt("edad"));
                persona.setIdPersona(resultado.getInt("idPersona"));
            }
        } catch (ClassNotFoundException e) {
            throw new MiExcepcion("Error de CLASE NO ENCONTRADA", e);
        } catch (SQLException e) {
            throw new MiExcepcion("Error SQL", e);
        }
        return persona;
    }

    public ArrayList<Persona> recuperarPersonas() throws MiExcepcion {
        Connection connection = null;
        ArrayList<Persona> personas = new ArrayList<Persona>();

        try {
            connection = DBUtil.recuperarConeccion();
            String sql = "SELECT * from persona";
            Statement listar = connection.createStatement();
            ResultSet resultado = listar.executeQuery(sql);
            while (resultado.next()) {
                Persona persona = new Persona();
                persona.setIdPersona(resultado.getInt("idPersona"));
                persona.setNombre(resultado.getString("nombre"));
                persona.setApellido(resultado.getString("apellido"));
                persona.setEdad(resultado.getInt("edad"));
                personas.add(persona);
            }
        } catch (ClassNotFoundException e) {
            throw new MiExcepcion("Error de CLASE NO ENCONTRADA", e);
        } catch (SQLException e) {
            throw new MiExcepcion("Error SQL", e);
        }
        return personas;
    }

    public void borrarPersona(int idPersona) throws MiExcepcion {
        Connection connection = null;
        String sql = "delete from persona where idPersona = ?";
        try {
            connection = DBUtil.recuperarConeccion();
            PreparedStatement borrar = connection.prepareStatement(sql);
            borrar.setInt(1, idPersona);
            borrar.execute();
        } catch (ClassNotFoundException e) {
            throw new MiExcepcion("Error de CLASE NO ENCONTRADA", e);
        } catch (SQLException e) {
            throw new MiExcepcion("Error SQL", e);
        }
    }

    public void exportarPersonas() {
        File file = new File("C:/Users/588472/Documents/datos.csv");
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Persona persona : recuperarPersonas()
                    ) {
                bw.write(persona.getNombre() + ',' + persona.getApellido() + ',' + persona.getEdad());
                bw.newLine();
                bw.flush();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MiExcepcion miExcepcion) {
            miExcepcion.printStackTrace();
        }
    }
}