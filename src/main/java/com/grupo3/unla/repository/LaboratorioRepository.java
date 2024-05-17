package com.grupo3.unla.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.grupo3.unla.model.Laboratorio;

public interface LaboratorioRepository extends MongoRepository<Laboratorio, Integer> {

}
