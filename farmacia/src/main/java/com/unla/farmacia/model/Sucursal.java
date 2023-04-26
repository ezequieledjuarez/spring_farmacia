package com.unla.farmacia.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sucursal {
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
