package com.unla.farmacia.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Producto {
    @JsonProperty("codigo_producto")
	private String codigoProducto;
	private String nombre;
    @JsonProperty("precio_unitario")
	private Long precioUnitario;
    @JsonProperty("tipo_producto")
	private String tipoProducto;
	private String descripcion;
	private String laboratorio;

	public Producto(String codigoProducto, String nombre, Long precioUnitario, String tipoProducto, String descripcion, String laboratorio) {
		this.codigoProducto = codigoProducto;
		this.nombre = nombre;
		this.precioUnitario = precioUnitario;
		this.tipoProducto = tipoProducto;
		this.descripcion = descripcion;
		this.laboratorio = laboratorio;
	}

	public String getCodigoProducto() {
		return this.codigoProducto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Long getPrecioUnitario() {
		return this.precioUnitario;
	}

	public String getTipoProducto() {
		return this.tipoProducto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public String getLaboratorio() {
		return this.laboratorio;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecioUnitario(Long precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}
}


