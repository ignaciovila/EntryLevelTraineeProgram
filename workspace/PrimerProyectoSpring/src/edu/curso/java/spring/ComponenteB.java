package edu.curso.java.spring;

import org.springframework.stereotype.Component;

@Component
public class ComponenteB implements IComponenteB{

	@Override
	public void metodoB() {
		System.out.println("Ejecutando metodoB");
	}

}
