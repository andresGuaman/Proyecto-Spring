package com.example.springMyStore.Modelo;

import javax.persistence.*;

//import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "DetalleCarrito")
public class DetalleCarrito {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long detc_id;
	@Column(name = "detc_cantidad")
	private int detc_cantidad;
	@Column(name = "detc_valor_unitario")
	private int detc_valor_unitario;
	@Column(name = "detc_valor_total")
	private int detc_valor_total;
	@Column(name = "detc_iva")
	private int detc_iva;
	@Column(name = "detc_descuento")
	private int detc_descuento;
	@Column(name = "detc_subtotal")
	private int detc_subtotal;
	//@JsonBackReference
	@JoinColumn(name = "encc_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private EncabezadoCarrito encabezadocarrito;
	@JoinColumn(name = "pp_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private ProductoProveedor productoproveedor;
	 public DetalleCarrito() {
		 
	 }
	 public DetalleCarrito(long detc_id, int cantidad, int vlaor_unitario, int valor_total, int iva, int descuento, int subtotal ) {
		 this.detc_id=detc_id;
		 this.detc_cantidad=cantidad;
		 this.detc_valor_unitario=vlaor_unitario;
		 this.detc_iva=iva;
		 this.detc_descuento=descuento;
		 this.detc_subtotal=subtotal;
	 }
	 public long getDetc_id() {
		return detc_id;
	}
	 public void setDetc_id(long detc_id) {
		this.detc_id = detc_id;
	}
	public int getDetc_cantidad() {
		return detc_cantidad;
	}
	public void setDetc_cantidad(int detc_cantidad) {
		this.detc_cantidad = detc_cantidad;
	}
	public int getDetc_valor_unitario() {
		return detc_valor_unitario;
	}
	public void setDetc_valor_unitario(int detc_valor_unitario) {
		this.detc_valor_unitario = detc_valor_unitario;
	}
	public int getDetc_valor_total() {
		return detc_valor_total;
	}
	public void setDetc_valor_total(int detc_valor_total) {
		this.detc_valor_total = detc_valor_total;
	}
	public void setDetc_iva(int detc_iva) {
		this.detc_iva = detc_iva;
	}
	public int getDetc_iva() {
		return detc_iva;
	}
	public void setDetc_descuento(int detc_descuento) {
		this.detc_descuento = detc_descuento;
	}
	public int getDetc_descuento() {
		return detc_descuento;
	}
	public void setDetc_subtotal(int detc_subtotal) {
		this.detc_subtotal = detc_subtotal;
	}
	public int getDetc_subtotal() {
		return detc_subtotal;
	}
	
}
