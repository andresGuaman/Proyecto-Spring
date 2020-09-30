package com.example.springMyStore.Modelo;

import java.util.List;

import javax.persistence.*;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Proveedor")
public class Proveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long prov_id;
	@Column(name = "prov_ruc", nullable = false)
	private String prov_ruc;
	@Column(name = "prov_empresa", nullable = false)
	private String prov_empresa;
	//@JsonBackReference
	@JoinColumn(name = "per_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Persona persona;
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "proveedor")
	private List<ProductoProveedor> productoproveedor;
	public Proveedor() {
			
	}
	public Proveedor(long prov_id, String prov_ruc, String prov_empresa) {
		this.prov_id=prov_id;
		this.prov_ruc=prov_ruc;
		this.prov_empresa=prov_empresa;
	}
	public void setProv_id(long prov_id) {
		this.prov_id = prov_id;
	}
	public long getProv_id() {
		return prov_id;
	}
	public String getProv_ruc() {
		return prov_ruc;
	}
	public void setProv_ruc(String prov_ruc) {
		this.prov_ruc = prov_ruc;
	}
	public String getProv_empresa() {
		return prov_empresa;
	}
	public void setProv_empresa(String prov_empresa) {
		this.prov_empresa = prov_empresa;
	}
}
