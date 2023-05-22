package com.unla.farmacia.controller.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.farmacia.model.Sucursal;
import com.unla.farmacia.repository.SucursalRepository;

@Controller
@RequestMapping("/sucursales/v1")
public class SucursalesContollerImpl {

	@Autowired
	private SucursalRepository sucursalRepository;

	@GetMapping(path = "/obtener-sucursales")
	public ResponseEntity<?> getAllSucursales() {
		ResponseEntity<?> response = null;
		List<Sucursal> sucursales = null;
		try {
			sucursales = sucursalRepository.findAll();
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response = new ResponseEntity<List<Sucursal>>(sucursales, HttpStatus.OK);
		return response;
	}

	@PostMapping(path = "/crear-sucursaless")
	public ResponseEntity<?> postSaveSucursal(@RequestBody List<Sucursal> listaSucursales) {
		ResponseEntity<?> response = null;
		try {
			for (Sucursal sucursal : listaSucursales) {
				sucursalRepository.save(sucursal);

			}
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response = new ResponseEntity<List<Sucursal>>(listaSucursales, HttpStatus.CREATED);
		return response;
	}

	@PostMapping(path = "/obtener-sucursal")
	public ResponseEntity<?> getSucursalByCuil(@RequestBody Sucursal sucursalBuscada) {
		ResponseEntity<?> response = null;
		Optional<Sucursal> sucursal = null;
		Sucursal sucursalEncontrada = null;
		try {
			sucursal = sucursalRepository.findById(sucursalBuscada.getNumeroSucursal());
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (null != sucursal.get()) {

			sucursalEncontrada = sucursal.get();
		}
		response = new ResponseEntity<Sucursal>(sucursalEncontrada, HttpStatus.OK);
		return response;
	}

	@PostMapping(path = "/actualizar-registro-sucursal")
	public ResponseEntity<?> updateSucursalByCuil(@RequestBody Sucursal sucursalActualizada) {
		ResponseEntity<?> response = null;
		Optional<Sucursal> sucursal = null;
		try {
			sucursal = sucursalRepository.findById(sucursalActualizada.getNumeroSucursal());
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (null == sucursal.get()) {
			response = new ResponseEntity<String>(
					"No existe le registro con el cuil [" + sucursalActualizada.getNumeroSucursal() + "]",
					HttpStatus.BAD_REQUEST);
		} else {
			sucursalRepository.save(sucursalActualizada);
		}

		response = new ResponseEntity<Sucursal>(sucursalActualizada, HttpStatus.OK);
		return response;
	}

	@PostMapping(path = "/borrar-registro-sucursal")
	public ResponseEntity<?> deleteRegistroSucursalById(@RequestBody Sucursal sucursalBuscada) {
		ResponseEntity<?> response = null;
		Optional<Sucursal> sucursal = null;
		int numeroSucursal = sucursalBuscada.getNumeroSucursal();
		try {
			sucursal = sucursalRepository.findById(numeroSucursal);
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (null == sucursal.get()) {
			response = new ResponseEntity<String>("No existe le registro con el cuil [" + numeroSucursal + "]",
					HttpStatus.BAD_REQUEST);
		} else {
			sucursalRepository.deleteById(numeroSucursal);
		}

		response = new ResponseEntity<String>("Se elimino el registro con el cuil [" + numeroSucursal + "]",
				HttpStatus.OK);
		return response;
	}

}
