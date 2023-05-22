package com.unla.farmacia.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@Document(collection = "venta")
public class Venta implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3621040837466571686L;
	private String fecha;
	@JsonProperty("nro_sucursal")
	private String nroSucursal;
	@JsonProperty("nro_ticket")
	private String nroTicket;
	@JsonProperty("codigo_venta")
	@Id
	private String codigoVenta;
	@JsonProperty("forma_de_pago")
	private String formaDePago;
	@JsonProperty("nro_de_tarjeta")
	private String nroDeTarjeta;
	@JsonProperty("lista_productos")
	private List<Producto> listaProductos;
	@JsonProperty("empleado_atencion")
	private String empleadoAtencion;
	@JsonProperty("empleado_caja")
	private String empleadoCaja;
	private Persona cliente;
	private Long totalFactura;

	public Venta() {
	}

	public Venta(String fecha, String nroSucursal, String nroTicket, String formaDePago, String nroDeTarjeta,
			List<Producto> listaProductos, String empleadoAtencion, String empleadoCaja, Persona cliente) {
		this.fecha = fecha;
		this.nroSucursal = nroSucursal;
		this.nroTicket = nroTicket;
		setCodigoVenta(nroSucursal, nroTicket);
		this.formaDePago = formaDePago;
		setNroDeTarjeta(nroDeTarjeta, formaDePago);
		this.listaProductos = listaProductos;
		this.empleadoAtencion = empleadoAtencion;
		this.empleadoCaja = empleadoCaja;
		this.cliente = cliente;
		setTotalFactura(listaProductos);
	}

	public Long totalFactura() {
		return this.totalFactura;
	}

	public void setTotalFactura(List<Producto> listaProductos) {
		Long totalFactura = 0L;

		for (Producto producto : listaProductos) {
			totalFactura = producto.getPrecioUnitario();
		}

		this.totalFactura = totalFactura;
	}

	public String getCodigoVenta() {
		return this.codigoVenta;
	}

	public void setCodigoVenta(String nroSucursal, String nroTicket) {
		this.codigoVenta = nroSucursal.concat("-").concat(nroTicket);
	}

	public String getFecha() {
		return this.fecha;
	}

	public String getNroSucursal() {
		return this.nroSucursal;
	}

	public String getNroTicket() {
		return this.nroTicket;
	}

	public String getFormaDePago() {
		return this.formaDePago;
	}

	public String getNroDeTarjeta() {
		return this.nroDeTarjeta;
	}

	public List<Producto> getProducto() {
		return this.listaProductos;
	}

	public String getEmpleadoAtencion() {
		return this.empleadoAtencion;
	}

	public String getEmpleadoCaja() {
		return this.empleadoCaja;
	}

	public Persona getCliente() {
		return this.cliente;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setNroSucursal(String nroSucursal) {
		this.nroSucursal = nroSucursal;
	}

	public void setNroTicket(String nroTicket) {
		this.nroTicket = nroTicket;
	}

	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}

	public void setNroDeTarjeta(String nroDeTarjeta, String formaDePago) {
		if ("Efectivo".equals(formaDePago)) {
			nroDeTarjeta = null;
		}
		this.nroDeTarjeta = nroDeTarjeta;
	}

	public void setProducto(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public void setEmpleadoAtencion(String empleadoAtencion) {
		this.empleadoAtencion = empleadoAtencion;
	}

	public void setEmpleadoCaja(String empleadoCaja) {
		this.empleadoCaja = empleadoCaja;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}
}
