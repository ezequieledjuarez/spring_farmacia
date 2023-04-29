package com.unla.farmacia.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document
public class Sucursal implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8570899434890672004L;
	@JsonProperty("lista_empleados")
	private List<String> listaEmpleados;
	private String encargado;

	public Sucursal(List<String> listaEmpleados, String encargado) {
		this.listaEmpleados = listaEmpleados;
		this.encargado = encargado;
	}

	public List<String> getListaEmpleados() {
		return this.listaEmpleados;
	}

	public String getEncargado() {
		return this.encargado;
	}

	public void setListaEmpleados(List<String> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}
}
