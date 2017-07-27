package com.cognizant.dao;

import com.cognizant.model.Persona;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class PersonasDAO {

    public void altaDePersona(Persona persona) {
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
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarPersona(Persona persona) {
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
        } catch (SQLException e) {
        }
    }

    public Persona buscarPersonaPorId(int idPersona) {
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
        } catch (SQLException e) {
        }
        return persona;
    }

    public ArrayList<Persona> buscarPersonaPorNombre(String nombre){
        ArrayList<Persona> personas = new ArrayList<Persona>();
        try {
            Connection connection = DBUtil.recuperarConeccion();
            String sql = "SELECT idPersona, nombre, apellido, edad FROM persona WHERE nombre = ?";
            PreparedStatement listar = connection.prepareStatement(sql);
            listar.setString(1, nombre);
            ResultSet resultado = listar.executeQuery();
            while (resultado.next()) {
                Persona persona = new Persona();
                persona.setIdPersona(resultado.getInt("idPersona"));
                persona.setNombre(resultado.getString("nombre"));
                persona.setApellido(resultado.getString("apellido"));
                persona.setEdad(resultado.getInt("edad"));
                personas.add(persona);
            }
        } catch (ClassNotFoundException e) {
        } catch (SQLException e) {
        }

        return personas;
    }

    public ArrayList<Persona> recuperarPersonas() {
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
        } catch (SQLException e) {
        }
        return personas;
    }

    public void borrarPersona(int idPersona) {
        Connection connection = null;
        String sql = "delete from persona where idPersona = ?";
        try {
            connection = DBUtil.recuperarConeccion();
            PreparedStatement borrar = connection.prepareStatement(sql);
            borrar.setInt(1, idPersona);
            borrar.execute();
        } catch (ClassNotFoundException e) {
        } catch (SQLException e) {
        }
    }

}