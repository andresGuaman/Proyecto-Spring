package com.example.springMyStore.Modelo;

import java.util.List;

import javax.persistence.*;

//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Empleado")

public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long emp_id;
	@Column(name = "emp_salario", nullable = false)
	private float emp_salario;
	@Column(name = "emp_usuario", nullable = false)
	private String emp_usuario;
	@Column(name = "emp_password", nullable = false)
	private String emp_password;
	//@JsonBackReference
	@JoinColumn(name = "per_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Persona persona;
	@JoinColumn(name = "rol_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Rol rol;
	//@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "empleado")
	private List<Chat> chat;
	public Empleado() {
		
	}
	public Empleado(long id, float emp_salario, String emp_usuario, String emp_password) {
		this.emp_id=id;
		this.emp_salario=emp_salario;
		this.emp_usuario=emp_usuario;
		this.emp_password=emp_password;
	}
	public void setEmp_id(long emp_id) {
		this.emp_id = emp_id;
	}
	public long getEmp_id() {
		return emp_id;
	}
	public void setEmp_salario(float emp_salario) {
		this.emp_salario = emp_salario;
	}
	public float getEmp_salario() {
		return emp_salario;
	}
	public void setEmp_usuario(String emp_usuario) {
		this.emp_usuario = emp_usuario;
	}
	public String getEmp_usuario() {
		return emp_usuario;
	}
	public void setEmp_password(String emp_password) {
		this.emp_password = emp_password;
	}
	public String getEmp_password() {
		return emp_password;
	}
}
