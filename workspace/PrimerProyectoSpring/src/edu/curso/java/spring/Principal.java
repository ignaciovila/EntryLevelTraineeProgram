package edu.curso.java.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Principal {

	public static void main(String[] args) {
		AbstractApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		ComponenteA componente = (ComponenteA) appContext.getBean("componenteA");

		componente.metodoA();
	}
}