package com.cognizant.patterns.builder;

public class Libro extends Producto {
	private int ISBN;

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	@Override
	public Producto crearProducto() {
		Producto producto = new Libro();
		return producto;
	}

	@Override
	public String toString() {
		return "Libro [ISBN=" + ISBN + "]";
	}
}
