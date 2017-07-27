package edu.curso.java.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.curso.java.hibernate.bo.Cliente;
import edu.curso.java.hibernate.bo.Direccion;
import edu.curso.java.hibernate.bo.Localidad;
import edu.curso.java.hibernate.bo.Telefono;

public class Principal {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		System.out.println("Ejecutando guardar");
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();

		/*Telefono telefono1 = new Telefono();
		telefono1.setNumero("1235456");
		session.save(telefono1);		
		
		Localidad localidad1 = new Localidad();
		localidad1.setNombre("CapFed");
		session.save(localidad1);
		
		Direccion direccion1 = new Direccion();
		direccion1.setCalle("Callao 123");
		session.save(direccion1);

		Cliente cliente1 = new Cliente();
		cliente1.setNombre("Juan");
		cliente1.setFechaAlta(new Date());
		session.save(cliente1);
		
		cliente1.setDireccion(direccion1);
		cliente1.getTelefonos().add(telefono1);
		cliente1.getLocalidades().add(localidad1);
		session.update(cliente1);
		
		telefono1.setCliente(cliente1);
		session.update(telefono1);
		
		localidad1.getClientes().add(cliente1);
		session.update(localidad1);
		
		direccion1.setCliente(cliente1);
		session.update(direccion1);*/
		
		String hql1 = "select c.direccion from Cliente as c " +
				"where c.id = :idBuscar";

		Query query1 = session.createQuery(hql1);
		query1.setInteger("idBuscar", 999999);
		Direccion direccionRecuperada1 = (Direccion) 
				query1.uniqueResult();

		String hql2 = "from Cliente as c " +
				"where c.direccion.calle like :calleBuscar";

		Query query2 = session.createQuery(hql2);
		query2.setString("calleBuscar", "%callao%");
		List<Cliente> clientesRecuperados1 = query2.list();

		String hql3 = "select c.telefonos from Cliente as c " +
				"where c.id = :idBuscar";

		Query query3 = session.createQuery(hql3);
		query3.setInteger("idBuscar", 999999);
		List<Telefono> telefonosRecuperados1 = query3.list();

		
		
		
		transaction.commit();
		
		session.close();
		
		sessionFactory.close();
	}
	
	
}
