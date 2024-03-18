package com.productos.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productos.rest.entity.Producto;

public interface RepoProducto extends JpaRepository<Producto, Integer>{

}
