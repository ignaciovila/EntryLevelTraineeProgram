package com.cognizant.patterns.builder;

public class Celular extends Producto {
	private String marca;
	private String nombre;
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public Producto crearProducto() {
		Producto producto = new Celular();
		return producto;
	}
	@Override
	public String toString() {
		return "Celular [marca=" + marca + ", nombre=" + nombre + "]";
	}
}
