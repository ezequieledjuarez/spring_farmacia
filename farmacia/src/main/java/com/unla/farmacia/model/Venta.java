package com.unla.farmacia.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Venta {
	private Ticket sucursal;
	@JsonProperty("numero_de_ticket")
	private String numeroDeTicket;
	private String fecha;
	@JsonProperty("forma_de_pago")
	private String formaDePago;
	private Producto producto;
	private Persona persona;
	@JsonProperty("persona_empleado_atencion")
	private Map<String, String> personaEmpleadoAtencion;

	public Venta(Ticket sucursal, String numeroDeTicket, String fecha, String formaDePago, Producto producto,
			Persona persona, Map<String, String> personaEmpleadoAtencion) {
		this.sucursal = sucursal;
		this.numeroDeTicket = numeroDeTicket;
		this.fecha = fecha;
		this.formaDePago = formaDePago;
		this.producto = producto;
		this.persona = persona;
		this.personaEmpleadoAtencion = personaEmpleadoAtencion;
	}

	public Ticket getSucursal() {
		return this.sucursal;
	}

	public String getNumeroDeTicket() {
		return this.numeroDeTicket;
	}

	public String getFecha() {
		return this.fecha;
	}

	public String getFormaDePago() {
		return this.formaDePago;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public Map<String, String> getPersonaEmpleadoAtencion() {
		return this.personaEmpleadoAtencion;
	}

	public void setSucursal(Ticket sucursal) {
		this.sucursal = sucursal;
	}

	public void setNumeroDeTicket(String numeroDeTicket) {
		this.numeroDeTicket = numeroDeTicket;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public void setPersonaEmpleadoAtencion(Map<String, String> personaEmpleadoAtencion) {
		this.personaEmpleadoAtencion = personaEmpleadoAtencion;
	}
}
