package com.unla.farmacia.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document
public class ObraSocial implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2297614000311642964L;

	private String nombre;

	private Long id;

	public ObraSocial(String nombre, Long id) {
		this.nombre = nombre;
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
