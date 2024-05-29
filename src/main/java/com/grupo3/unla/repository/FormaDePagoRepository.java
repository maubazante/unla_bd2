package com.grupo3.unla.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.grupo3.unla.model.FormaDePago;

public interface FormaDePagoRepository extends MongoRepository<FormaDePago, Integer> {

}
