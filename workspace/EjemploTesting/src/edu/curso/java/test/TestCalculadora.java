package edu.curso.java.test;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.curso.java.calculadora.Calculadora;

public class TestCalculadora {

	@Test
	public void testSumar() {
		Calculadora calculadora = new Calculadora();
		int num1 = 1;
		int num2 = 1;
		int total = calculadora.sumar(num1, num2);
		int totalEsperado = 2;
		assertEquals("1 + 1 tiene que ser 2", totalEsperado, total);
	}

	@Test
	public void testRestar() {
		Calculadora calculadora = new Calculadora();
		int num1 = 1;
		int num2 = 1;
		int total = calculadora.restar(num1, num2);
		int totalEsperado = 0;
		assertEquals("1 - 1 tiene que ser 0", totalEsperado, total);
	}

}
