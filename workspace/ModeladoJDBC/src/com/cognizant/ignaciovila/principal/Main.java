package com.cognizant.ignaciovila.principal;

import com.cognizant.ignaciovila.bo.*;
import com.cognizant.ignaciovila.dao.GestorDePersonas;
import com.cognizant.ignaciovila.excepciones.MiExcepcion;

public class Main {

    public static void main(String[] args) {
        GestorDePersonas gestorDePersonas = new GestorDePersonas();

        gestorDePersonas.exportarPersonas();
    }
}