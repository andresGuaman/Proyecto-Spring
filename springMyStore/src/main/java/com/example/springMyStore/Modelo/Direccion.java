package com.example.springMyStore.Modelo;

import javax.persistence.*;
//import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Direccion")
public class Direccion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long dir_id;
	@Column(name = "dir_cuidad")
	private String dir_cuidad;
	@Column(name = "dir_calle1")
	private String dir_calle1;
	@Column(name = "dir_calle2")
	private String dir_calle2;
	@Column(name = "dir_referencia")
	private String dir_referencia;
	@Column(name = "dir_postal")
	private String dir_postal;
	@Column(name = "dir_latitud")
	private String dir_latitud;

	//@JsonBackReference
	@JoinColumn(name = "per_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Persona persona;

	public Direccion() {
	}

	public Direccion(long dir_id, String dir_cuidad, String dir_calle1, String dir_calle2, String dir_referencia, String dir_postal, String dir_latitud) {
		this.dir_id=dir_id;
		this.dir_cuidad=dir_cuidad;
		this.dir_calle1=dir_calle1;
		this.dir_calle2=dir_calle2;
		this.dir_referencia=dir_referencia;
		this.dir_postal=dir_postal;
		this.dir_latitud=dir_latitud;
	}
	public long getDir_id() {
		return dir_id;
	}
	public void setDir_id(long dir_id) {
		this.dir_id = dir_id;
	}
	public String getDir_calle1() {
		return dir_calle1;
	}
	public void setDir_calle1(String dir_calle1) {
		this.dir_calle1 = dir_calle1;
	}
	public String getDir_calle2() {
		return dir_calle2;
	}
	public void setDir_calle2(String dir_calle2) {
		this.dir_calle2 = dir_calle2;
	}
	public String getDir_cuidad() {
		return dir_cuidad;
	}
	public void setDir_cuidad(String dir_cuidad) {
		this.dir_cuidad = dir_cuidad;
	}
	public String getDir_referencia() {
		return dir_referencia;
	}
	public void setDir_referencia(String dir_referencia) {
		this.dir_referencia = dir_referencia;
	}
	public String getDir_postal() {
		return dir_postal;
	}
	public void setDir_postal(String dir_postal) {
		this.dir_postal = dir_postal;
	}
	public String getDir_latitud() {
		return dir_latitud;
	}
	public void setDir_latitud(String dir_latitud) {
		this.dir_latitud = dir_latitud;
	}
}
