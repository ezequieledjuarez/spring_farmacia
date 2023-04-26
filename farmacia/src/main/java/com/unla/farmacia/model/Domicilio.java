package com.unla.farmacia.model;

public class Domicilio {
	private String calle;
	private Long numero;
	private String localidad;
	private String provincia;

	public Domicilio(String calle, Long numero, String localidad, String provincia) {
		this.calle = calle;
		this.numero = numero;
		this.localidad = localidad;
		this.provincia = provincia;
	}

	public String getCalle() {
		return this.calle;
	}

	public Long getNumero() {
		return this.numero;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
}

