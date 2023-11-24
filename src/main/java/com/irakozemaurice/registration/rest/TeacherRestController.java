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
import com.irakozemaurice.registration.model.Teacher;
import com.irakozemaurice.registration.model.TeacherRole;
import com.irakozemaurice.registration.service.TeacherService;

@RestController
@RequestMapping("/api")
public class TeacherRestController {

	private TeacherService service;

	@Autowired
	public TeacherRestController(TeacherService service) {

		this.service = service;

	}

	@GetMapping("/teachers")
	public List<Teacher> getTeachers() {

		List<Teacher> teachers = service.findAll();

		return teachers;

	}

	@GetMapping("/teachers/roles")
	public TeacherRole[] getRoles() {

		return TeacherRole.values();

	}

	@PostMapping("/teachers")
	public Teacher addTeacher(@RequestBody Teacher theTeacher) {

		theTeacher.setId(0);

		Teacher dbTeacher = service.save(theTeacher);

		return dbTeacher;

	}

	@GetMapping("/teachers/{id}")
	public Teacher getTeacher(@PathVariable int id) {

		Teacher theTeacher = service.findById(id);

		if (theTeacher == null) {

			throw new ResourceNotFoundException("Teacher id not found - " + id);

		}

		return theTeacher;
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
