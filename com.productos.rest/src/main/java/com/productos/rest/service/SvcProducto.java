package com.productos.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productos.rest.entity.Producto;
import com.productos.rest.repository.RepoProducto;

@Service
public class SvcProducto
{
	@Autowired
	private RepoProducto repoProducto;

	public List<Producto> listarProductos()
	{
		return repoProducto.findAll();
	}

	public void guardarProducto(Producto producto)
	{
		repoProducto.save(producto);
	}

	public Producto obtenerProductoById(Integer id)
	{
		return repoProducto.findById(id).get();
	}

	public void eliminarProducto(Integer id)
	{
		repoProducto.deleteById(id);
	}
}
