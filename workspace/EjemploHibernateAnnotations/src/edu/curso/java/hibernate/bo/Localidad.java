package edu.curso.java.hibernate.bo;

import javax.persistence.*;
import java.util.*;

@Entity
public class Localidad {
	private Long id;
	private String nombre;
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	@ManyToMany(mappedBy="localidades")
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
