package com.alineacion.demo.demo.service;

import java.util.List;
import java.util.Optional;

import com.alineacion.demo.demo.entity.Productos;

public interface IProductosService {
	List<Productos> buscarTodos();
	Optional<Productos> buscarPorID(int idProducto);
	Productos guardar(Productos producto);
	Productos editar(Productos producto, int idProducto);
	void eliminar(int producto);
	
	
	

}
