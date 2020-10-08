package com.example.springMyStore.Modelo;

import java.util.List;

import javax.persistence.*;

//import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Categoria")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cat_id;
	@Column(name = "cat_genero")
	private String cat_genero;
	@Column(name = "cat_edad")
	private int cat_edad;
	@Column(name = "cat_marca")
	private String cat_marca;
	@Column(name = "cat_categoria")
	private String cat_categoria;
	@Column(name = "cat_color")
	private String cat_color;
	//@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY , mappedBy = "categoria")
	private List<Producto> producto;
	public Categoria() {
		
	}
	public Categoria(long cat_id, String cat_genero, int cat_edad, String cat_marca, String cat_categoria, String cat_color) {
		this.cat_id=cat_id;
		this.cat_genero=cat_genero;
		this.cat_edad=cat_edad;
		this.cat_marca=cat_marca;
		this.cat_categoria=cat_categoria;
		this.cat_color=cat_color;
	}
	public long getCat_id() {
		return cat_id;
	}
	public void setCat_id(long cat_id) {
		this.cat_id = cat_id;
	}
	public String getCat_genero() {
		return cat_genero;
	}
	public void setCat_genero(String cat_genero) {
		this.cat_genero = cat_genero;
	}
	public int getCat_edad() {
		return cat_edad;
	}
	public void setCat_edad(int cat_edad) {
		this.cat_edad = cat_edad;
	}
	public String getCat_marca() {
		return cat_marca;
	}
	public void setCat_marca(String cat_marca) {
		this.cat_marca = cat_marca;
	}
	public String getCat_categoria() {
		return cat_categoria;
	}
	public void setCat_categoria(String cat_categoria) {
		this.cat_categoria = cat_categoria;
	}
	public String getCat_color() {
		return cat_color;
	}
	public void setCat_color(String cat_color) {
		this.cat_color = cat_color;
	}
}
