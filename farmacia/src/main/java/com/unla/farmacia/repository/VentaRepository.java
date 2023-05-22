package com.unla.farmacia.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.unla.farmacia.model.Venta;

@Repository
public interface VentaRepository extends MongoRepository<Venta, String>{

}
