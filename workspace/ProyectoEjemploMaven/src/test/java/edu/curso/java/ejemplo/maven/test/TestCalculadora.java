package edu.curso.java.ejemplo.maven.test;


import org.junit.*;
import static org.junit.Assert.*;

import edu.curso.java.ejemplo.maven.general.Calculadora;

public class TestCalculadora {

	@Test
	public void sumar() {
		Calculadora calculadora = new Calculadora();
		double total = calculadora.sumar(10, 10);
		assertTrue("Error al sumar", total == 20);
	}
	
	@Test
	public void restar() {
		Calculadora calculadora = new Calculadora();
		double total = calculadora.restar(20, 15);
		assertTrue("Error al restar", total == 5);
	}
}
