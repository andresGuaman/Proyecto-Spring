package com.example.springMyStore.Modelo;

import java.util.List;

import javax.persistence.*;

//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Producto")

public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pro_id;
	@Column(name = "pro_foto")
	private String pro_foto;
	@Column(name = "pro_descripcion")
	private String pro_descripcion;
	@Column(name = "pro_costo")
	private int pro_costo;
	@Column(name = "pro_precio")
	private int pro_precio;
	@Column(name = "pro_stock")
	private int pro_stock;
	@Column(name = "pro_codigo_barra")
	private String pro_codigo_barra;
	@Column(name = "pro_marca")
	private String pro_marca;
	@Column(name = "pro_modelo")
	private String pro_modelo;
	//@JsonBackReference
	@JoinColumn(name = "cat_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Categoria categoria;
	//@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "producto")
	private List<ProductoProveedor> productoproveedor;
	public Producto() {
		
	}
public Producto(long pro_id, String pro_foto, String pro_descripcion, int pro_costo, int pro_precio, int stock, String pro_codigo_barra, String pro_marca, String pro_modelo) {
		this.pro_id=pro_id;
		this.pro_foto=pro_foto;
		this.pro_descripcion=pro_descripcion;
		this.pro_costo=pro_costo;
		this.pro_precio=pro_precio;
		this.pro_stock=stock;
		this.pro_codigo_barra=pro_codigo_barra;
		this.pro_marca=pro_marca;
		this.pro_modelo=pro_modelo;
	}
public long getPro_id() {
	return pro_id;
}
public void setPro_id(long pro_id) {
	this.pro_id = pro_id;
}
public String getPro_foto() {
	return pro_foto;
}
public void setPro_foto(String pro_foto) {
	this.pro_foto = pro_foto;
}
public String getPro_descripcion() {
	return pro_descripcion;
}
public void setPro_descripcion(String pro_descripcion) {
	this.pro_descripcion = pro_descripcion;
}
public int getPro_costo() {
	return pro_costo;
}
public void setPro_costo(int pro_costo) {
	this.pro_costo = pro_costo;
}
public int getPro_precio() {
	return pro_precio;
}
public void setPro_precio(int pro_precio) {
	this.pro_precio = pro_precio;
}
public int getPro_stock() {
	return pro_stock;
}
public void setPro_stock(int pro_stock) {
	this.pro_stock = pro_stock;
}
public String getPro_codigo_barra() {
	return pro_codigo_barra;
}
public void setPro_codigo_barra(String pro_codigo_barra) {
	this.pro_codigo_barra = pro_codigo_barra;
}
public String getPro_marca() {
	return pro_marca;
}
public void setPro_marca(String pro_marca) {
	this.pro_marca = pro_marca;
}
public String getPro_modelo() {
	return pro_modelo;
}
public void setPro_modelo(String pro_modelo) {
	this.pro_modelo = pro_modelo;
}
}
