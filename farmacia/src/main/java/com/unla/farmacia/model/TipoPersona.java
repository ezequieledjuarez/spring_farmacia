package com.unla.farmacia.model;

import java.io.Serializable;

import com.unla.farmacia.exceptions.InvalidTipoPersonaException;

public enum TipoPersona implements Serializable{

	CLIENTE("cliente"),
	EMPLEADO("empleado"),
	ENCARGADO("encargado"),
	NINGUNO("ninguno");

	private String tipoPersona;
	
	TipoPersona(String tipoPersona) {
		this.tipoPersona=tipoPersona;
	}

	public String getTipoPersona() {
		return tipoPersona;
	}
	
	public static TipoPersona fromTipoPersona(String inputTipoPersona) throws InvalidTipoPersonaException{
		TipoPersona persona = null;
		for(TipoPersona tipoPersona: TipoPersona.values()) {
			if(tipoPersona.getTipoPersona().equals(inputTipoPersona)) {
				persona = tipoPersona;
			}
			throw new InvalidTipoPersonaException(422, "No se encontró el tipo de persona ["+ inputTipoPersona+"]");
		}
		return persona;
	}
	
}
