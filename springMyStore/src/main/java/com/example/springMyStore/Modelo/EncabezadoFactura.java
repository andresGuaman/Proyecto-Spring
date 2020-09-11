package com.example.springMyStore.Modelo;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table (name = "EncabezadoFactura")
public class EncabezadoFactura {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long enc_id;
	@Column(name = "enc_fecha", nullable = false)
	private Date enc_fecha;
	@Column(name = "enc_descuento", nullable = false)
	private int enc_descuento;
	@Column(name = "enc_subtotal", nullable = false)
	private int enc_subtotal;
	@Column(name = "enc_iva", nullable = false)
	private int enc_iva;
	@Column(name = "enc_total", nullable = false)
	private int enc_total;
	
	
	@JsonBackReference
	@JoinColumn(name = "cli_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	@JoinColumn(name = "met_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private MetodoPago metodopago;
	
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "encabezadofactura")
	private List<DetalleFactura> detallefactura;
	public EncabezadoFactura() {
		
	}
	public EncabezadoFactura(long enc_id, Date enc_fecha, int enc_descuento, int enc_subtotal, int enc_iva, int enc_tota) {
		this.enc_id=enc_id;
		this.enc_fecha=enc_fecha;
		this.enc_descuento=enc_descuento;
		this.enc_subtotal=enc_subtotal;
		this.enc_iva=enc_iva;
		this.enc_total=enc_tota;
	}
	public long getEnc_id() {
		return enc_id;
	}
	public void setEnc_id(long enc_id) {
		this.enc_id = enc_id;
	}
	public Date getEnc_fecha() {
		return enc_fecha;
	}
	public void setEnc_fecha(Date enc_fecha) {
		this.enc_fecha = enc_fecha;
	}
	public int getEnc_descuento() {
		return enc_descuento;
	}
	public void setEnc_descuento(int enc_descuento) {
		this.enc_descuento = enc_descuento;
	}
	public int getEnc_subtotal() {
		return enc_subtotal;
	}
	public void setEnc_subtotal(int enc_subtotal) {
		this.enc_subtotal = enc_subtotal;
	}
	public int getEnc_iva() {
		return enc_iva;
	}
	public void setEnc_iva(int enc_iva) {
		this.enc_iva = enc_iva;
	}
	public int getEnc_total() {
		return enc_total;
	}
	public void setEnc_total(int enc_total) {
		this.enc_total = enc_total;
	}
}
