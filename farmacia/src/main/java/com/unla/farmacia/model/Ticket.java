package com.unla.farmacia.model;


public class Ticket {

	private Venta venta;

	public Ticket(Venta venta) {
		this.venta = venta;
	}

	public Venta getVenta() {
		return this.venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}
}




