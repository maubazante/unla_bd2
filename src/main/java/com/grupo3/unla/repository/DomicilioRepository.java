package com.grupo3.unla.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.grupo3.unla.model.Domicilio;

public interface DomicilioRepository extends MongoRepository<Domicilio, Integer> {

}
