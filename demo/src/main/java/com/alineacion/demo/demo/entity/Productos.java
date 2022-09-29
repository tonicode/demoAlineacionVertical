package com.alineacion.demo.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Productos {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(nullable = false)
private int producto_id; 

public int getProducto_id() {
	return producto_id;
}

public void setProducto_id(int producto_id) {
	this.producto_id = producto_id;
}

public String getNombre_producto() {
	return nombre_producto;
}

public void setNombre_producto(String nombre_producto) {
	this.nombre_producto = nombre_producto;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public int getCategoria_id() {
	return categoria_id;
}

public void setCategoria_id(int categoria_id) {
	this.categoria_id = categoria_id;
}

@Column(nullable = false)
private String nombre_producto;

@Column(nullable = false)
private String descripcion;

@Column(nullable = false)
private int categoria_id;




	
}
