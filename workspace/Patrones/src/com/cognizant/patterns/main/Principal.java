package com.cognizant.patterns.main;

import com.cognizant.patterns.builder.*;

public class Principal {

	public static void main(String[] args) {
		/*
		Singleton singleton1 = Singleton.getInstance();
		
		System.out.println(singleton1.recuperarIns());
		
		Singleton singleton2 = Singleton.getInstance();
		
		System.out.println(singleton1.recuperarIns());
		System.out.println(singleton2.recuperarIns());
		*/
		
		Director director = new Director();
		Libro libro = (Libro) director.crearProd();
		libro.setISBN(123456789);
		Celular celular = (Celular) director.crearProd();
		celular.setMarca("Samsung");
		celular.setNombre("S7");
		
		System.out.println(celular.toString());
		System.out.println(libro.toString());
		
	}

}
