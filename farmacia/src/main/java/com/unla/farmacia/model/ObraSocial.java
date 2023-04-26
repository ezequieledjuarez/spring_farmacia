package com.unla.farmacia.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ObraSocial {
	private String nombre;
    @JsonProperty("numero_de_afiliado")
	private Long numeroDeAfiliado;

	public ObraSocial(String nombre, Long numeroDeAfiliado) {
		this.nombre = nombre;
		this.numeroDeAfiliado = numeroDeAfiliado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Long getNumeroDeAfiliado() {
		return this.numeroDeAfiliado;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setNumeroDeAfiliado(Long numeroDeAfiliado) {
		this.numeroDeAfiliado = numeroDeAfiliado;
	}
}
