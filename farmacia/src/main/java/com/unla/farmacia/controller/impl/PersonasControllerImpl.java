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

import com.unla.farmacia.model.Persona;
import com.unla.farmacia.repository.PersonaRepository;

@Controller
@RequestMapping("/personas/v1")
public class PersonasControllerImpl {

	@Autowired
	private PersonaRepository personaRepository;

	@GetMapping(path = "/obtener-personas")
	public ResponseEntity<?> getAllPersonas() {
		ResponseEntity<?> response = null;
		List<Persona> personas = null;
		try {
			personas = personaRepository.findAll();
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response = new ResponseEntity<List<Persona>>(personas, HttpStatus.OK);
		return response;
	}

	@PostMapping(path = "/crear-persona")
	public ResponseEntity<?> postSavePersona(@RequestBody List<Persona> listaPersonas) {
		ResponseEntity<?> response = null;
		try {
			for (Persona persona : listaPersonas) {
				personaRepository.save(persona);

			}
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response = new ResponseEntity<List<Persona>>(listaPersonas, HttpStatus.CREATED);
		return response;
	}

	@PostMapping(path = "/obtener-persona")
	public ResponseEntity<?> getPersonaByCuil(@RequestBody Persona personaBuscada) {
		ResponseEntity<?> response = null;
		Optional<Persona> persona = null;
		Persona personaEncontrada = null;
		try {
			persona = personaRepository.findById(personaBuscada.getCuil());
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (null != persona.get()) {

			personaEncontrada = persona.get();
		}
		response = new ResponseEntity<Persona>(personaEncontrada, HttpStatus.OK);
		return response;
	}

	@PostMapping(path = "/actualizar-registro-persona")
	public ResponseEntity<?> updatePersonaByCuil(@RequestBody Persona personaActualizada) {
		ResponseEntity<?> response = null;
		Optional<Persona> persona = null;
		try {
			persona = personaRepository.findById(personaActualizada.getCuil());
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (null == persona.get()) {
			response = new ResponseEntity<String>(
					"No existe le registro con el cuil [" + personaActualizada.getCuil() + "]", HttpStatus.BAD_REQUEST);
		} else {
			personaRepository.save(personaActualizada);
		}

		response = new ResponseEntity<Persona>(personaActualizada, HttpStatus.OK);
		return response;
	}

	@PostMapping(path = "/borrar-registro-persona")
	public ResponseEntity<?> deleteRegistroPersonaById(@RequestBody Persona personaBuscada) {
		ResponseEntity<?> response = null;
		Optional<Persona> persona = null;
		String cuil = personaBuscada.getCuil();
		try {
			persona = personaRepository.findById(cuil);
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (null == persona.get()) {
			response = new ResponseEntity<String>("No existe le registro con el cuil [" + cuil + "]",
					HttpStatus.BAD_REQUEST);
		} else {
			personaRepository.deleteById(cuil);
		}

		response = new ResponseEntity<String>("Se elimino el registro con el cuil [" + cuil + "]", HttpStatus.OK);
		return response;
	}

}
