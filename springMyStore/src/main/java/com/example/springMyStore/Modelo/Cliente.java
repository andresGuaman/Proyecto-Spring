package com.example.springMyStore.Modelo;

import java.util.List;

import javax.persistence.*;

//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long cli_id;
	@Column(name = "cli_descuento")
	private double cli_descuento;
	@Column(name = "cli_usuario")
	private String cli_usuario;
	@Column (name = "cli_password")
	private String cli_password;

	//@JsonBackReference
	@JoinColumn(name = "per_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Persona persona;

	//@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cliente")
	private List<Chat> chat;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cliente")
	private List<EncabezadoCarrito> encabezadocarrito;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cliente")
	private List<EncabezadoFactura> encabezadofactura;
	public Cliente() {
		
	}
	public Cliente(long id, double cli_descuento, String cli_usuario, String cli_password) {
		this.cli_id= id;
		this.cli_descuento=cli_descuento;
		this.cli_usuario=cli_usuario;
		this.cli_password=cli_password;
	}
	public long getCli_id() {
		return cli_id;
	}
	public void setCli_id(long clie_id) {
		this.cli_id = clie_id;
	}
	public double getCli_descuento() {
		return cli_descuento;
	}
	public void setCli_descuento(double cli_descuento) {
		this.cli_descuento = cli_descuento;
	}
	public String getCli_usuario() {
		return cli_usuario;
	}
	public void setCli_usuario(String cli_usuario) {
		this.cli_usuario = cli_usuario;
	}
	public String getCli_password() {
		return cli_password;
	}
	public void setCli_password(String cli_password) {
		this.cli_password = cli_password;
	}
}
