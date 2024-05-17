package com.grupo3.unla.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.grupo3.unla.model.Sucursal;

public interface SucursalRepository extends MongoRepository<Sucursal, Integer> {

}
