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
import com.irakozemaurice.registration.model.Course;
import com.irakozemaurice.registration.service.CourseService;

@RestController
@RequestMapping("/api")
public class CourseRestController {

	private CourseService service;

	@Autowired
	public CourseRestController(CourseService service) {
		this.service = service;
	}

	@GetMapping("/courses")
	public List<Course> getCourses() {
		List<Course> courses = service.findAll();
		return courses;
	}

	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course theCourse) {
		theCourse.setId(0);

		// save the au
		Course dbCourse = service.save(theCourse);

		// dbaAcademicUnit has a new id from the database
		return dbCourse;
	}

	// @PutMapping("/aus")
	// public AcademicUnit updateAcademicUnit(@RequestBody AcademicUnit
	// theAcademicUnit) {

	// // update the AcademicUnit
	// AcademicUnit dbAcademicUnit = auService.save(theAcademicUnit);

	// // dbAcademicUnit has a new id from the database
	// return dbAcademicUnit;
	// }

	// add mapping for GET /aus/{auId} - get AcademicUnit by id
	@GetMapping("/courses/{id}")
	public Course getCourse(@PathVariable int id) {

		Course theCourse = service.findById(id);

		if (theCourse == null) {
			throw new ResourceNotFoundException("Course id not found - " + id);
		}

		return theCourse;
	}

	// // add mapping for DELETE /aus/{auId} - delete an AcademicUnit
	// @DeleteMapping("/aus/{auId}")
	// public String deleteAcademicUnit(@PathVariable int auId) {

	// AcademicUnit theAcademicUnit = auService.findById(auId);

	// if (theAcademicUnit == null)
	// throw new RuntimeException("AcademicUnit id not found - " + auId);

	// // delete the AcademicUnit
	// auService.deleteById(auId);

	// return "deleted AcademicUnit - " + auId;
	// }

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(ResourceNotFoundException e) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(e.getMessage());
		errorResponse.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

}
