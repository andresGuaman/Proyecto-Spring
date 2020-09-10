package com.example.springMyStore.Modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity 
@Table(name = "Persona")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long per_id;
	@Column(name = "per_cedula", nullable = false)
	private String per_cedula;
	@Column(name = "per_nombre", nullable = false)
	private String per_nombre;
	@Column(name = "per_apellido", nullable = false)
	private String per_apellido;
	@Column(name = "per_telefono", nullable = false)
	private String per_telefono;
	@Column(name = "per_correo", nullable = false)
	private String per_correo;
	@Column(name = "per_fecha_creacion", nullable = false)
	private Date per_fecha_creacion;
	@Column(name = "per_estado", nullable = false)
	private String per_estado;
	@Column(name = "per_foto", nullable = false)
	private String per_foto;
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dir_id" )
	private List<Direccion> direccion;
	
	public Persona() {
		
	}
	public Persona(long per_id, String per_cedula, String per_nombre, String per_apellido, String per_telefono, String per_correo, Date per_fecha_creacion, String per_estado, String per_foto ) {
		this.per_id=per_id;
		this.per_cedula=per_cedula;
		this.per_nombre=per_nombre;
		this.per_apellido=per_apellido;
		this.per_telefono=per_telefono;
		this.per_correo=per_correo;
		this.per_fecha_creacion=per_fecha_creacion;
		this.per_estado=per_estado;
		this.per_foto=per_foto;
	}
	
	
}
