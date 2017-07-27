package edu.curso.java.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.curso.java.spring.bo.*;
import edu.curso.java.spring.service.*;


public class Principal0 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractApplicationContext appContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		Producto producto = new Producto();
		producto.setNombre("Celular");
		double precio = 10000;
		producto.setPrecio(precio);
		
		ProductoService service = (ProductoService) appContext.getBean(ProductoService.class);
		try {
			service.crearNuevoProductoSimple(producto);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
