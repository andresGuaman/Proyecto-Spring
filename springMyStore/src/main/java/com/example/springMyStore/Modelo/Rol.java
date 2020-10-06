package com.example.springMyStore.Modelo;

import java.util.List;

import javax.persistence.*;

//import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Rol")
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long rol_id;
	@Column(name = "rol_nombre", nullable = false)
	private String rol_nombre;
	@Column(name = "rol_departamento", nullable = false)
	private String rol_departamento;
	@Column(name="rol_estado",nullable = false)
	private String rol_estado;
	
//	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rol")
	private List<Empleado> empleado;
	
	public Rol() {
		
	}
	public Rol(long id, String rol_nombre, String rol_departamento, String rol_estado) {
		this.rol_id=id;
		this.rol_nombre=rol_nombre;
		this.rol_departamento=rol_departamento;
		this.rol_estado=rol_estado;
		
	}
	public long getRol_id() {
		return rol_id;
	}
	public void setRol_id(long rol_id) {
		this.rol_id = rol_id;
	}
	public String getRol_nombre() {
		return rol_nombre;
	}
	public void setRol_nombre(String rol_nombre) {
		this.rol_nombre = rol_nombre;
	}
	public String getRol_departamento() {
		return rol_departamento;
	}
	public void setRol_departamento(String rol_departamento) {
		this.rol_departamento = rol_departamento;
	}
	public String getRol_estado() {
		return rol_estado;
	}
	public void setRol_estado(String rol_estado) {
		this.rol_estado = rol_estado;
	}
}
