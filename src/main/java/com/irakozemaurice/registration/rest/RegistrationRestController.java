package com.irakozemaurice.registration.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irakozemaurice.registration.exceptions.ErrorResponse;
import com.irakozemaurice.registration.exceptions.ResourceNotFoundException;
import com.irakozemaurice.registration.model.Registration;
import com.irakozemaurice.registration.service.RegistrationService;

@RestController
@RequestMapping("/api")
public class RegistrationRestController {

	private RegistrationService service;

	@Autowired
	public RegistrationRestController(RegistrationService service) {

		this.service = service;

	}

	@GetMapping("/registrations")
	public List<Registration> getRegistrations() {

		List<Registration> registrations = service.findAll();

		return registrations;

	}

	@PostMapping("/registrations")
	public Registration addRegistration(@RequestBody Registration theRegistration) {

		theRegistration.setId(0);

		Registration dbRegistration = service.save(theRegistration);

		return dbRegistration;

	}

	@GetMapping("/registrations/{id}")
	public Registration getRegistration(@PathVariable int id) {

		Registration theRegistration = service.findById(id);

		if (theRegistration == null) {
			throw new ResourceNotFoundException("Registration id not found - " + id);
		}

		return theRegistration;
	}

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(ResourceNotFoundException e) {

		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());

		errorResponse.setMessage(e.getMessage());

		errorResponse.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

	}

}
