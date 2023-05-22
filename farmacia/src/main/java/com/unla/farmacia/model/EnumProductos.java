package com.unla.farmacia.model;

import com.unla.farmacia.exceptions.InvalidParameterException;

public enum EnumProductos {
	IBUPROFENO("Ibuprofeno 400 mg", "Laboratorio"), AMOXICILINA("Amoxicilina 500 mg", "Laboratorio"),
	IBUEVANOL("Ibuevanol 20 mg", "Laboratorio"), MIGRAL("Migral 500 mg", "Laboratorio"),
	KETEROLAC("Keterolaco 20 mg", "Laboratorio"),
	GILLETE("Repuesto Gillete","Perfumeria"),
	DESODORANTE("Desodorante antitranspirante", "Perfumeria"),
	DENTIFRICO("Dentifrico Colgate", "Perfumeria");

	private String nombre;
	private String tipo;

	EnumProductos(String nombre, String tipo) {
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public static EnumProductos fromNombre(String nombreProducto) throws InvalidParameterException {
		for (EnumProductos producto : EnumProductos.values())
			if (producto.getNombre().toLowerCase().contains(nombreProducto.toLowerCase()))
				return producto;
		throw new InvalidParameterException("No se encuentró el producto con el nombre [" + nombreProducto + "]");
	}
}
