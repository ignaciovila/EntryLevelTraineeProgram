package com.cognizant.ignaciovila.bo;

import java.sql.*;

/**
 * Created by 588472 on 17/08/2016.
 */
public class Persona {
    private int idPersona;
    private String nombre;
    private String apellido;
    private int edad;

    public String toString() {
        return "Persona [idPersona = " + idPersona + ", nombre = " + nombre + ", apellido = " + apellido + ", edad = "
                + edad + "]";
    }

    public Persona() {

    }

    public Persona(int idPersona, String nombre, String apellido, int edad) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idPersona;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || (!(o instanceof Persona)) ){
            return false;
        }

        Persona persona = (Persona) o;

        return idPersona == persona.idPersona;

    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}