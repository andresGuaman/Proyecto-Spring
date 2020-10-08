package com.example.springMyStore.Modelo;

import java.util.List;

import javax.persistence.*;

//import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "MetodoPago")
public class MetodoPago {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long met_id;
	@Column(name = "met_metodo")
	private String met_metodo;
	@Column(name = "met_nro_tarjeta")
	private String met_nro_tarjeta;
	@Column(name = "met_tipo")
	private String met_tipo;
	//@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "metodopago")
	private List<EncabezadoFactura> encabezadofactura;
	
	public MetodoPago() {
		
	}
	public MetodoPago(long met_id, String met_metodo, String met_nro_tarjeta, String met_tipo) {
		this.met_id=met_id;
		this.met_metodo=met_metodo;
		this.met_nro_tarjeta=met_nro_tarjeta;
		this.met_tipo=met_tipo;
	}
	public long getMet_id() {
		return met_id;
	}
	public void setMet_id(long met_id) {
		this.met_id = met_id;
	}
	public String getMet_metodo() {
		return met_metodo;
	}
	public void setMet_metodo(String met_metodo) {
		this.met_metodo = met_metodo;
	}
	public String getMet_nro_tarjeta() {
		return met_nro_tarjeta;
	}
	public void setMet_nro_tarjeta(String met_nro_tarjeta) {
		this.met_nro_tarjeta = met_nro_tarjeta;
	}
	public String getMet_tipo() {
		return met_tipo;
	}
	public void setMet_tipo(String met_tipo) {
		this.met_tipo = met_tipo;
	}
}
