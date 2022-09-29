package com.alineacion.demo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alineacion.demo.demo.entity.Productos;



public interface ProductosRepository  extends JpaRepository<Productos, Integer>{
	

}
