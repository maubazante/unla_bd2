package com.grupo3.unla.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.grupo3.unla.model.Venta;

public interface VentaRepository extends MongoRepository<Venta, Integer> {

}
