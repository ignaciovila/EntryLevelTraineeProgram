package edu.curso.java.spring;

import org.springframework.stereotype.Component;

@Component
public class ComponenteBImp2 implements ComponenteB {

	public ComponenteBImp2() {
		System.out.println("Creando un ComponenteBImp2");
	}

	@Override
	public void hacerMetodoB() {
		System.out.println("Haciendo Método B");
	}
	
}