package edu.curso.java.ejemplo.maven.general;


import java.net.URL;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.*;

public class Principal {
	
	private static Logger log = Logger.getLogger(Principal.class);
	
	public static void main(String[] args) {
		
		DOMConfigurator.configure(URL.class.getResource("/log4j.xml"));
	    log.info("Cargando la app");
	    Calculadora calculadora = new Calculadora();
	    double total = calculadora.sumar(10, 10);
	    log.info("Resultado de la calculadora: " + total);
	}

}
