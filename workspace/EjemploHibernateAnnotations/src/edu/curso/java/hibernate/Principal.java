package edu.curso.java.hibernate;

import java.util.*;
import org.hibernate.*;
import edu.curso.java.hibernate.bo.*;

public class Principal {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		/*
		Cliente cliente = new Cliente();

		double saldo = 5000;		
		cliente.setNombre("Juan");
		cliente.setApellido("Perez");
		cliente.setEsClienteVip(true);
		cliente.setSaldo(saldo);
		cliente.setFechaAlta(new Date());

		session.save(cliente);
		
		System.out.println("Id generado " + cliente.getId());
		
		// BUSCAR POR ID
		long idBuscar = 1;
		Cliente cliente = (Cliente) session.load(Cliente.class, idBuscar);
		
		System.out.println(cliente.getNombre());
		System.out.println(cliente.getApellido());
		
		//UPDATE
		cliente.setApellido("Orlando");
		session.update(cliente);
		
		cliente = (Cliente) session.load(Cliente.class, idBuscar);
		System.out.println(cliente.getApellido());
		
		//DELETE
		session.delete(cliente);
				
		Query query = session.createQuery("from Cliente as c order by c.apellido");
		List<Cliente> clientes = query.list();
		for (Cliente c : clientes) {
			System.out.println(c.getApellido());;			
		}
		
		
		Direccion direccion = new Direccion();
		direccion.setCalle("Tucuman 3720");
		direccion.setCp(1035);
		
		session.save(direccion);
		
		Cliente cliente = new Cliente();

		double saldo = 5000;		
		cliente.setNombre("Juan");
		cliente.setApellido("Perez");
		cliente.setEsClienteVip(true);
		cliente.setSaldo(saldo);
		cliente.setFechaAlta(new Date());
		cliente.setDireccion(direccion);
		
		session.save(cliente);
		
		long idBuscar = 7;
		Cliente cliente = (Cliente) session.load(Cliente.class, idBuscar);
		
		System.out.println(cliente.getDireccion().getCalle());
		*/
		
		Telefono tel1 = new Telefono();
		tel1.setNumero("123456789");
		
		Direccion dir1 = new Direccion();
		dir1.setCalle("Tucuman 3720");
		dir1.setCp(1035);
				
		Localidad loc1 = new Localidad();
		loc1.setNombre("CABA");
		
		Cliente cli1 = new Cliente();
		cli1.setNombre("Ramiro");
		cli1.setApellido("Ramirez");
		cli1.setEsClienteVip(true);
		cli1.setFechaAlta(new Date());
		cli1.setSaldo(100000.0);
		
		cli1.setDireccion(dir1);
		
		tel1.setCliente(cli1);
		dir1.setCliente(cli1);
		//	MUY IMPORTANTE!!!
		// NADA DE setLista(lista)
		cli1.getLocalidades().add(loc1);
		loc1.getClientes().add(cli1);
		
		session.save(tel1);
		session.save(dir1);
		session.save(loc1);		
		session.save(cli1);		
				
		transaction.commit();
		
		session.close();
		
		sessionFactory.close();
	}	
}
