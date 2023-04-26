package com.unla.farmacia.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Persona {
	private String cuil;
	private Long dni;
	private Domicilio domicilio;
	@JsonProperty("obra_social")
	private ObraSocial obraSocial;
	@JsonProperty("tipo_persona")
	private String tipoPersona;

	public Persona(String cuil, Long dni, Domicilio domicilio, ObraSocial obraSocial, String tipoPersona) {
		this.cuil = cuil;
		this.dni = dni;
		this.domicilio = domicilio;
		this.obraSocial = obraSocial;
		this.tipoPersona = tipoPersona;
	}

	public String getCuil() {
		return this.cuil;
	}

	public Long getDni() {
		return this.dni;
	}

	public Domicilio getDomicilio() {
		return this.domicilio;
	}

	public ObraSocial getObraSocial() {
		return this.obraSocial;
	}

	public String getTipoPersona() {
		return this.tipoPersona;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public void setObraSocial(ObraSocial obraSocial) {
		this.obraSocial = obraSocial;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}
}

