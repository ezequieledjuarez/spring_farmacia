package com.unla.farmacia.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.unla.farmacia.model.Persona;

@Repository
public interface PersonaRepository extends MongoRepository<Persona, String>{

}
