package edu.curso.java.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ComponenteAImp implements ComponenteA {

	@Autowired
	@Qualifier(value="componenteBImp")
	private ComponenteB componenteB;
	
	public ComponenteAImp() {
		System.out.println("Creando un ComponenteAImp");
	}
	
	@Override
	public void hacerMetodoA() {
		System.out.println("hacerMetodoA en ComponenteAImp");
	}
	
}