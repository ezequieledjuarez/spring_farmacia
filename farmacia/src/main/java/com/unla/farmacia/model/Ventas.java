package com.unla.farmacia.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Ventas implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8768242249410698394L;
	@JsonProperty("lista_ventas")
	List<Venta> listaVentas;

	public Ventas() {
		super();
	}

	public Ventas(List<Venta> listaVentas) {
		super();
		this.listaVentas = listaVentas;
	}

	public List<Venta> getListaVentas() {
		return listaVentas;
	}

	public void setListaVentas(List<Venta> listaVentas) {
		this.listaVentas = listaVentas;
	}

}
