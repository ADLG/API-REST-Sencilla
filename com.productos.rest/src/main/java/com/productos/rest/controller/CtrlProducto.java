package com.productos.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productos.rest.entity.Producto;
import com.productos.rest.service.SvcProducto;

@RestController
public class CtrlProducto
{
	@Autowired
	private SvcProducto svcProducto;

	@GetMapping("/productos")
	public List<Producto> listarProductos()
	{
		return svcProducto.listarProductos();
	}

	@GetMapping("/productos/{id}")
	public ResponseEntity<Producto> obtenerProducto(@PathVariable Integer id)
	{
		try
		{
			Producto producto = svcProducto.obtenerProductoById(id);
			return new ResponseEntity<Producto>(producto,HttpStatus.OK);
		} catch (Exception e)
		{
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/productos")
	public void guardarProducto(@RequestBody Producto producto)
	{
		svcProducto.guardarProducto(producto);
	}

	@PutMapping("/productos/{id}")
	public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto, @PathVariable Integer id)
	{
		try
		{
			Producto productoExistente = svcProducto.obtenerProductoById(id);

			productoExistente.setNombre(producto.getNombre());
			productoExistente.setPrecio(producto.getPrecio());

			svcProducto.guardarProducto(productoExistente);
			return new ResponseEntity<Producto>(HttpStatus.OK);	
		} catch (Exception e)
		{
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);	
		}
	}

	@DeleteMapping("/productos/{id}")
	public void eliminarProducto(@PathVariable Integer id)
	{
		svcProducto.eliminarProducto(id);
	}
}
