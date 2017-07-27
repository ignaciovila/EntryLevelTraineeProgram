package edu.curso.java.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Principal0 {

	public static void main(String[] args) {
		AbstractApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		ComponenteA componente = (ComponenteA) appContext.getBean("componenteAImp");

		componente.hacerMetodoA();
	}

}