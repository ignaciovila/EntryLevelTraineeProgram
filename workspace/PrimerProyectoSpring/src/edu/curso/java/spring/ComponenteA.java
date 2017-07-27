package edu.curso.java.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ComponenteA implements IComponenteA {
	
	@Autowired
	@Qualifier(value="componenteB")
	private IComponenteB componente;

	@Override
	public void metodoA() {
		System.out.println("Ejecutando metodoA");
		componente.metodoB();
	}
	
}

