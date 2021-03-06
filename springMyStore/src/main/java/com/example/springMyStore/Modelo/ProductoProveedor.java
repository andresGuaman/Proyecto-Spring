package com.example.springMyStore.Modelo;

import java.util.List;

import javax.persistence.*;

//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ProductoProovedor")
public class ProductoProveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pp_id;
	@Column(name = "pp_estado")
	private String pp_estado;
	//@JsonBackReference
	@JoinColumn(name = "pro_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Producto producto;
	@JoinColumn(name = "prov_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Proveedor proveedor;
	//@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "productoproveedor")
	private List<DetalleCarrito> detallecarrito;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "productoproveedor")
	private List<DetalleFactura> detallefactura;
	public ProductoProveedor() {
		
	}
	public ProductoProveedor(long pp_id, String pp_estado) {
		this.pp_id=pp_id;
		this.pp_estado=pp_estado;
	}
	public long getPp_id() {
		return pp_id;
	}
	public void setPp_id(long pp_id) {
		this.pp_id = pp_id;
	}
	public void setPp_estado(String pp_estado) {
		this.pp_estado = pp_estado;
	}
	public String getPp_estado() {
		return pp_estado;
	}
	
}
