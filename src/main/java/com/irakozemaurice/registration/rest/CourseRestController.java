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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irakozemaurice.registration.exceptions.ErrorResponse;
import com.irakozemaurice.registration.exceptions.ResourceNotFoundException;
import com.irakozemaurice.registration.model.AcademicUnit;
import com.irakozemaurice.registration.model.Course;
import com.irakozemaurice.registration.model.Department;
import com.irakozemaurice.registration.service.AUService;
import com.irakozemaurice.registration.service.CourseService;

@RestController
@RequestMapping("/api")
public class CourseRestController {

	private CourseService service;

	private AUService auService;

	@Autowired
	public CourseRestController(CourseService service, AUService auService) {

		this.service = service;

		this.auService = auService;
	}

	@GetMapping("/courses")
	public List<Course> getCourses() {

		List<Course> courses = service.findAll();

		return courses;

	}

	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course theCourse) {

		theCourse.setId(0);

		Course dbCourse = service.save(theCourse);

		return dbCourse;

	}

	@GetMapping("/courses/perStudent")
	public List<Course> getCoursesPerStudent(@RequestParam(value = "student_id", required = true) int student_id) {

		List<Course> courses = service.findByStudent(student_id);

		return courses;

	}

	@GetMapping("/courses/perDepartmentAndSemester")
	public List<Course> getCoursesPerDepartmentAndSemester(
			@RequestParam(value = "sem_id", required = true) int sem_id,
			@RequestParam(value = "department_name", required = true) Department department_name) {

		AcademicUnit au = auService.findByDepartment(department_name);

		List<Course> courses = service.findByDepartmentAndSemester(sem_id, au.getId());

		return courses;

	}

	@GetMapping("/courses/{id}")
	public Course getCourse(@PathVariable int id) {

		Course theCourse = service.findById(id);

		if (theCourse == null) {
			throw new ResourceNotFoundException("Course id not found - " + id);
		}

		return theCourse;
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
