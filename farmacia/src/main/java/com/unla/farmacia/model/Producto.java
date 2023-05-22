package com.unla.farmacia.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.unla.farmacia.exceptions.InvalidParameterException;

@Document(collection = "producto")
@JsonInclude(Include.NON_NULL)
public class Producto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2517704805353730955L;
	@JsonProperty("codigo_producto")
	private String codigoProducto;
	@JsonProperty("nombre_producto")
	private String nombre;
	@JsonProperty("precio")
	private Long precioUnitario;
	@JsonProperty("tipo_producto")
	private String tipoProducto;
	private String descripcion;
	private String laboratorio;
	private int cantidad;

	public Producto() {
		super();
	}

	public Producto(String nombre, Long precioUnitario, int cantidad) throws InvalidParameterException {
		setNombre(nombre);
		this.precioUnitario = precioUnitario;
		setTipoProducto(nombre);
		this.cantidad = cantidad;
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

	public void setNombre(String nombre) throws InvalidParameterException {
		this.nombre = EnumProductos.fromNombre(nombre).getNombre();
	}

	public void setPrecioUnitario(Long precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public void setTipoProducto(String nombre) throws InvalidParameterException {
		this.tipoProducto = EnumProductos.fromNombre(nombre).getTipo();
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
