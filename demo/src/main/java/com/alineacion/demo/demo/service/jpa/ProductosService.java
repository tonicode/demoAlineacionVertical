package com.alineacion.demo.demo.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alineacion.demo.demo.repository.ProductosRepository;
import com.alineacion.demo.demo.service.IProductosService;
import com.alineacion.demo.demo.entity.Productos;

@Service
public class ProductosService implements IProductosService{
	
	@Autowired
	private ProductosRepository repoProductos;
	
	@Override
	public List<Productos> buscarTodos() {
		// TODO Auto-generated method stub
		return repoProductos.findAll();
	}

	@Override
	public Optional<Productos> buscarPorID(int idProducto) {
		// TODO Auto-generated method stub
		return repoProductos.findById(idProducto);
	}

	
	@Override
	public Productos guardar(Productos producto) {
		 
		return repoProductos.save(producto);
	}

	@Override
	public Productos editar(Productos producto, int idProducto) {
		
		
		return repoProductos.save(producto);
	}
	
	
	@Override
	public void eliminar(int Idproducto) {
		repoProductos.deleteById(Idproducto);
		
	}
	
	


}
