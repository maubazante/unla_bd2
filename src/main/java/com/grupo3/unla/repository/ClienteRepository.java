package com.grupo3.unla.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.grupo3.unla.model.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, Integer> {

}
