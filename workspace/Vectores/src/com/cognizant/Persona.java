package com.cognizant;

public class Persona {
    private int id;
    private String nombre;

    public Persona(int id, String nombre)
    {
        setId(id);
        setNombre(nombre);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persona persona = (Persona) o;

        if (id != persona.id) return false;
        return nombre != null ? nombre.equals(persona.nombre) : persona.nombre == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        System.out.println("Ejecutando hascode: " + result);
        return result;
    }
}
