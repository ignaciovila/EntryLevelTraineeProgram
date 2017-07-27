package edu.curso.java.hibernate.bo;

import java.util.*;

import javax.persistence.*;

@Entity
public class Cliente {
	
	private Long id;
	private String nombre;
	private String apellido;
	private Date fechaAlta;
	private Double saldo;
	private boolean esClienteVip;
	private Direccion direccion;
	//private Set<Telefono> telefonos = new HashSet<Telefono>();
	private List<Telefono> telefonos = new ArrayList<Telefono>();
	private List<Localidad> localidades = new ArrayList<Localidad>();
	
	@OneToMany(mappedBy="cliente")
	public List<Telefono> getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
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
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public Date getFechaAlta() {
		return fechaAlta;
	}
	
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public boolean isEsClienteVip() {
		return esClienteVip;
	}
	
	public void setEsClienteVip(boolean esClienteVip) {
		this.esClienteVip = esClienteVip;
	}
	
	@ManyToOne
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	@ManyToMany
	public List<Localidad> getLocalidades() {
		return localidades;
	}
	public void setLocalidades(List<Localidad> localidades) {
		this.localidades = localidades;
	}
}
