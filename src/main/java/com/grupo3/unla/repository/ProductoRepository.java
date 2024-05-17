package com.grupo3.unla.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.grupo3.unla.model.Producto;

public interface ProductoRepository extends MongoRepository<Producto, Integer>{

}
