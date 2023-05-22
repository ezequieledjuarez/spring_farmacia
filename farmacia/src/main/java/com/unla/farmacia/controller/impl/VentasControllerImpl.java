package com.unla.farmacia.controller.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.farmacia.model.Venta;
import com.unla.farmacia.model.Ventas;
import com.unla.farmacia.repository.VentaRepository;

@Controller
@RequestMapping("/ventas/v1")
public class VentasControllerImpl {

	@Autowired
	private VentaRepository ventaRepository;

	@PostMapping(path = "/cargar-ventas")
	public ResponseEntity<?> postSaveVenta(@RequestBody Ventas listaVentas) {
		ResponseEntity<?> response = null;

		try {
			for (Venta venta : listaVentas.getListaVentas()) {
				Venta ventaCarga = new Venta(venta.getFecha(), venta.getNroSucursal(), venta.getNroTicket(), venta.getFormaDePago(), venta.getNroDeTarjeta(), venta.getProducto(), venta.getEmpleadoAtencion(), venta.getEmpleadoCaja(), venta.getCliente());
				ventaRepository.save(ventaCarga );
			}
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response = new ResponseEntity<Ventas>(listaVentas, HttpStatus.CREATED);

		return response;
	}

	@GetMapping(path = "/obtener-ventas")
	public ResponseEntity<?> getVentaById() {
		ResponseEntity<?> response = null;
		List<Venta> ventas = null;
		try {
			ventas = ventaRepository.findAll();
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response = new ResponseEntity<List<Venta>>(ventas, HttpStatus.CREATED);

		return response;
	}

}
