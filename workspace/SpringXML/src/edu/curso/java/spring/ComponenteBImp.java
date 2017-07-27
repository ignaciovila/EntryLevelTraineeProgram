package edu.curso.java.spring;

import org.springframework.stereotype.Component;

@Component
public class ComponenteBImp implements ComponenteB {

	public ComponenteBImp() {
		System.out.println("Creando un ComponenteBImp");
	}

	@Override
	public void hacerMetodoB() {
		System.out.println("Haciendo Método B");
	}
	
}