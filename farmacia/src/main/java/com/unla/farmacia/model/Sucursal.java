package com.unla.farmacia.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Document
@JsonInclude(Include.NON_NULL)
public class Sucursal implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8570899434890672004L;
	@JsonProperty("lista_empleados")
	private List<String> listaEmpleados;
	private Persona encargado;
	private String domicilio;

	@Id
	@JsonProperty("numero_sucursal")
	private int numeroSucursal;

	public Sucursal() {
		super();
	}

	public Sucursal(List<String> listaEmpleados, Persona encargado, String domicilio, int numeroSucursal) {
		super();
		this.listaEmpleados = listaEmpleados;
		this.encargado = encargado;
		this.domicilio = domicilio;
		this.numeroSucursal = numeroSucursal;
	}

	public List<String> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(List<String> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public Persona getEncargado() {
		return encargado;
	}

	public void setEncargado(Persona encargado) {
		this.encargado = encargado;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public int getNumeroSucursal() {
		return numeroSucursal;
	}

	public void setNumeroSucursal(int numeroSucursal) {
		this.numeroSucursal = numeroSucursal;
	}

}
