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
import com.irakozemaurice.registration.model.Semester;
import com.irakozemaurice.registration.model.SemesterType;
import com.irakozemaurice.registration.service.SemesterService;

@RestController
@RequestMapping("/api")
public class SemesterRestController {

	private SemesterService service;

	@Autowired
	public SemesterRestController(SemesterService service) {
		this.service = service;
	}

	@GetMapping("/semesters")
	public List<Semester> getSemesters() {
		List<Semester> semesters = service.findAll();
		return semesters;
	}

	@GetMapping("/semesters/types")
	public SemesterType[] getTypes() {
		return SemesterType.values();
	}

	@PostMapping("/semesters")
	public Semester addSemester(@RequestBody Semester theSemester) {

		theSemester.setId(0);

		Semester dbSemester = service.save(theSemester);

		return dbSemester;
	}

	@GetMapping("/semesters/{id}")
	public Semester getSemester(@PathVariable int id) {

		Semester theSemester = service.findById(id);

		if (theSemester == null) {
			throw new ResourceNotFoundException("Semester id not found - " + id);
		}

		return theSemester;
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
