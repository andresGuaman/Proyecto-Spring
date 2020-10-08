package com.example.springMyStore.Modelo;

import javax.persistence.*;

//import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "DetalleFactura")
public class DetalleFactura {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long det_id;
	@Column(name = "det_cantidad")
	private int det_cantidad;
	@Column(name = "det_valor_unitario")
	private int det_valor_unitario;
	@Column(name = "det_valor_total")
	private int det_valor_total;
	@Column(name = "det_iva")
	private int det_iva;
	@Column(name = "det_descuento")
	private int det_descuento;
	@Column(name = "det_subtotal")
	private int det_subtotal;
	@Column(name = "det_total")
	private int det_total;
	//@JsonBackReference
	@JoinColumn(name = "enc_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private EncabezadoFactura encabezadofactura;
	@JoinColumn(name = "pp_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private ProductoProveedor productoproveedor;
	public DetalleFactura() {
		
	}
	public DetalleFactura(long det_id, int det_cantidad, int det_valor_unitario, int det_valor_total, int det_iva, int det_descuencto, int det_subtotal, int det_total) {
		this.det_id=det_id;
		this.det_cantidad=det_cantidad;
		this.det_valor_unitario=det_valor_unitario;
		this.det_valor_total=det_valor_total;
		this.det_iva=det_iva;
		this.det_descuento=det_descuencto;
		this.det_subtotal=det_subtotal;
		this.det_total=det_total;
	}
	public long getDet_id() {
		return det_id;
	}
	public void setDet_id(long det_id) {
		this.det_id = det_id;
	}
	public int getDet_cantidad() {
		return det_cantidad;
	}
	public void setDet_cantidad(int det_cantidad) {
		this.det_cantidad = det_cantidad;
	}
	public int getDet_valor_unitario() {
		return det_valor_unitario;
	}
	public void setDet_valor_unitario(int det_valor_unitario) {
		this.det_valor_unitario = det_valor_unitario;
	}
	public int getDet_subtotal() {
		return det_subtotal;
	}
	public void setDet_subtotal(int det_subtotal) {
		this.det_subtotal = det_subtotal;
	}
	public int getDet_total() {
		return det_total;
	}
	public void setDet_total(int det_total) {
		this.det_total = det_total;
	}
	public int getDet_descuento() {
		return det_descuento;
	}
	public void setDet_descuento(int det_descuento) {
		this.det_descuento = det_descuento;
	}
	public int getDet_iva() {
		return det_iva;
	}
	public void setDet_iva(int det_iva) {
		this.det_iva = det_iva;
	}
	public int getDet_valor_total() {
		return det_valor_total;
	}
	public void setDet_valor_total(int det_valor_total) {
		this.det_valor_total = det_valor_total;
	}
}
