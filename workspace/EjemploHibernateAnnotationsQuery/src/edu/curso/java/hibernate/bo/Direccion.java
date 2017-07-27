package edu.curso.java.hibernate.bo;

import javax.persistence.*;

@Entity
public class Direccion {

	private Long id;
	private String calle;
	private String cp;
	private Cliente cliente;
	
	@OneToOne(mappedBy="direccion")
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	
}
