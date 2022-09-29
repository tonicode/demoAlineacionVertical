package com.alineacion.demo.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alineacion.demo.demo.entity.Productos;
import com.alineacion.demo.demo.service.IProductosService;


import java.util.Optional;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductoController {

	
	@Autowired
	private IProductosService svcProducto;
	
	
    @GetMapping("/")
    public String saludo(){
        return  "Bienvenido a la API de prueba para alineación vertical!!";
    }

    @GetMapping("productos")
    public ResponseEntity<List<Productos>>  productos(){
    	    return  ResponseEntity.ok( svcProducto.buscarTodos());
    		
    }
    

    @GetMapping("productos/{id}")
    public ResponseEntity<?> productosById(@PathVariable int id){
    	Optional<Productos> producto_optional = svcProducto.buscarPorID(id);
    	if(producto_optional.isPresent()) {
    		return ResponseEntity.ok(producto_optional.get()); 
    	}
    	
    	return ResponseEntity.notFound().build();  
    }

    
    @PostMapping("productos")
    public ResponseEntity<?> crearProducto(@RequestBody Productos producto) {
    	return ResponseEntity.status(HttpStatus.CREATED).body(svcProducto.guardar(producto));
    }
    
    
    

    @PutMapping("productos/{id}")
    public ResponseEntity<?> editarProducto(@RequestBody Productos producto,  @PathVariable int id) {
    	
    	
    	 Optional<Productos> prod = svcProducto.buscarPorID(id);
    	 if (prod.isPresent()) {
    		  Productos productoDB = prod.get();
    		  productoDB.setNombre_producto(producto.getNombre_producto());
    		  productoDB.setDescripcion(producto.getDescripcion());
    		  productoDB.setCategoria_id(producto.getCategoria_id());
    		  return ResponseEntity.status(HttpStatus.CREATED).body(svcProducto.guardar(productoDB));
              
         }
         return ResponseEntity.notFound().build();
    	//return ResponseEntity.status(HttpStatus.CREATED).body(svcProducto.guardar(producto));
    }
    
    
         

    @DeleteMapping("productos/{id}")

    public ResponseEntity<?> eliminar(@PathVariable int id) {
        Optional<Productos> o = svcProducto.buscarPorID(id);
        if (o.isPresent()) {
            svcProducto.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    

}
