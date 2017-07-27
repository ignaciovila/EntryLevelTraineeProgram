package com.cognizant.ignaciovila.excepciones;

public class MiExcepcion extends Exception {
    public MiExcepcion(String message) {
        super(message);
    }

    public MiExcepcion(String msg, Throwable exception) {
        super(msg, exception);
    }
}
