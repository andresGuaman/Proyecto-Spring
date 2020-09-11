package com.example.springMyStore.Modelo;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "EncabezadoCarrito")
public class EncabezadoCarrito {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long encc_id;
	@Column(name = "encc_fecha", nullable = false)
	private Date encc_fecha;
	@Column(name = "encc_descuento", nullable = false)
	private int encc_descuento;
	@Column(name = "encc_subtotal", nullable = false)
	private int encc_subtotal;
	@Column(name = "encc_iva", nullable = false)
	private int encc_iva;
	@Column(name = "encc_total", nullable = false)
	private int encc_total;
	@JsonBackReference
	@JoinColumn(name = "cli_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "encabezadocarrito")
	private List<DetalleCarrito> detallecarrito;
	public EncabezadoCarrito() {
		
	}
	public EncabezadoCarrito(long encc_id, Date encc_fecha, int encc_descuento, int encc_subtotal, int encc_iva, int encc_total){
		this.encc_id=encc_id;
		this.encc_fecha=encc_fecha;
		this.encc_descuento=encc_descuento;
		this.encc_subtotal=encc_subtotal;
		this.encc_subtotal=encc_subtotal;
		this.encc_iva=encc_iva;
		this.encc_total=encc_total;
	}
	public void setEncc_descuento(int encc_descuento) {
		this.encc_descuento = encc_descuento;
	}
	public int getEncc_descuento() {
		return encc_descuento;
	}
	public void setEncc_fecha(Date encc_fecha) {
		this.encc_fecha = encc_fecha;
	}
	public Date getEncc_fecha() {
		return encc_fecha;
	}
	public void setEncc_id(long encc_id) {
		this.encc_id = encc_id;
	}
	public long getEncc_id() {
		return encc_id;
	}
	public void setEncc_iva(int encc_iva) {
		this.encc_iva = encc_iva;
	}
	public int getEncc_iva() {
		return encc_iva;
	}
	public void setEncc_subtotal(int encc_subtotal) {
		this.encc_subtotal = encc_subtotal;
	}
	public int getEncc_subtotal() {
		return encc_subtotal;
	}
	public int getEncc_total() {
		return encc_total;
	}
	public void setEncc_total(int encc_total) {
		this.encc_total = encc_total;
	}
}
