package com.cognizant.patterns.singleton;

public class Singleton {

	private static Singleton instance = null;
	private static int contador;
	
	private Singleton() {
		contador++;
	}
	
	public static Singleton getInstance(){
		if(instance == null){
			instance = new Singleton();
		}
		return instance;
	}
	
	public int recuperarIns(){
		return contador;
	}
}
