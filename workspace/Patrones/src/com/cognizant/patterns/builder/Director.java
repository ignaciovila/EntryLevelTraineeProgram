package com.cognizant.patterns.builder;

public class Director {
	ProductoBuilder builder;
	
	public Producto crearProd(){
		return this.builder.crearProducto();
	}
}
