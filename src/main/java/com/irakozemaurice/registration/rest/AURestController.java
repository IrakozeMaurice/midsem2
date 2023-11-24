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
import com.irakozemaurice.registration.model.AcademicUnit;
import com.irakozemaurice.registration.model.Department;
import com.irakozemaurice.registration.model.Faculty;
import com.irakozemaurice.registration.model.Program;
import com.irakozemaurice.registration.service.AUService;

@RestController
@RequestMapping("/api")
public class AURestController {

	private AUService auService;

	@Autowired
	public AURestController(AUService auService) {

		this.auService = auService;

	}

	@GetMapping("/aus")
	public List<AcademicUnit> getAcademicUnits() {

		List<AcademicUnit> academicUnits = auService.findAll();

		return academicUnits;

	}

	@GetMapping("/aus/programs")
	public Program[] getPrograms() {

		return Program.values();

	}

	@GetMapping("/aus/faculties")
	public Faculty[] getFaculties() {

		return Faculty.values();

	}

	@GetMapping("/aus/departments")
	public Department[] getDepartments() {

		return Department.values();

	}

	@PostMapping("/aus")
	public AcademicUnit addAcademicUnit(@RequestBody AcademicUnit theAcademicUnit) {

		theAcademicUnit.setId(0);

		AcademicUnit dbaAcademicUnit = auService.save(theAcademicUnit);

		return dbaAcademicUnit;
	}

	@GetMapping("/aus/{auId}")
	public AcademicUnit getAcademicUnit(@PathVariable int auId) {

		AcademicUnit theAcademicUnit = auService.findById(auId);

		if (theAcademicUnit == null) {
			throw new ResourceNotFoundException("Academic Unit id not found - " + auId);
		}

		return theAcademicUnit;
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
