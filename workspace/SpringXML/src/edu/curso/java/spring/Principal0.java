package edu.curso.java.spring;

public class Principal0 {

	public static void main(String[] args) {
		AbstractApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		ComponenteA componente = (ComponenteA) appContext.getBean("componenteA");

		componente.hacerMetodoA();
	}

}