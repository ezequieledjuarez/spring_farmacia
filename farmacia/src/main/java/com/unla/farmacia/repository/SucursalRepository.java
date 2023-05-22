package com.unla.farmacia.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.unla.farmacia.model.Sucursal;

@Repository
public interface SucursalRepository extends MongoRepository<Sucursal, Integer> {
	
}
