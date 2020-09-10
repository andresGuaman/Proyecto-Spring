package com.example.springMyStore.Modelo;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name = "Direccion")
public class Direccion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long dir_id;
	@Column(name = "dir_cuidad", nullable = false)
	private String dir_cuidad;
	@Column(name = "dir_calle1", nullable = false)
	private String dir_calle1;
	@Column(name = "dir_calle2", nullable = false)
	private String dir_calle2;
	@Column(name = "dir_referencia", nullable = false)
	private String dir_referencia;
	@Column(name = "dir_postal", nullable = false)
	private String dir_postal;
	@Column(name = "dir_latitud", nullable = false)
	private String dir_latitud;
	@JsonManagedReference
	@JoinColumn(name = "per_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Persona persona;
	public Direccion() {
		
	}
}
