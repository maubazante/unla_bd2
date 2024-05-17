package com.grupo3.unla.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.grupo3.unla.model.Empleado;

public interface EmpleadoRepository extends MongoRepository<Empleado, Integer> {

}
