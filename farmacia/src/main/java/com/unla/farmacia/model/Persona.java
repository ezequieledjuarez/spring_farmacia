package com.unla.farmacia.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Document(collection = "persona")
@JsonInclude(Include.NON_NULL)
public class Persona implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2911252653417687530L;
	@Id
	private String cuil;
	private Long dni;
	private Domicilio domicilio;
	@JsonProperty("obra_social")
	private ObraSocial obraSocial;
	@JsonProperty("tipo_de_persona")
	private TipoPersona tipoPersona;
	@JsonProperty("numero_de_afiliado")
	private Long numeroDeAfiliado;

	public Long getNumeroDeAfiliado() {
		return numeroDeAfiliado;
	}

	public void setNumeroDeAfiliado(Long numeroDeAfiliado) {
		this.numeroDeAfiliado = numeroDeAfiliado;
	}

	public Persona() {
		super();
	}

	public Persona(String cuil, Long dni, Domicilio domicilio, String obraSocial, TipoPersona tipoPersona,
			Long numeroDeAfiliado) {
		this.cuil = cuil;
		this.dni = dni;
		this.domicilio = domicilio;
		this.obraSocial = new ObraSocial(obraSocial);
		this.tipoPersona = tipoPersona;
		this.numeroDeAfiliado = numeroDeAfiliado;
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

	public TipoPersona getTipoPersona() {
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

	public void setTipoPersona(TipoPersona tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	@Override
	public String toString() {
		return "Persona [cuil=" + cuil + ", dni=" + dni + ", domicilio=" + domicilio + ", obraSocial=" + obraSocial
				+ ", tipoPersona=" + tipoPersona + ", numeroDeAfiliado=" + numeroDeAfiliado + "]";
	}

}
