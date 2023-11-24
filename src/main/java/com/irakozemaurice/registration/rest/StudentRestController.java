package com.irakozemaurice.registration.rest;

import java.util.ArrayList;
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
import com.irakozemaurice.registration.model.Department;
import com.irakozemaurice.registration.model.Registration;
import com.irakozemaurice.registration.model.Student;
import com.irakozemaurice.registration.service.AUService;
import com.irakozemaurice.registration.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private StudentService service;
	private AUService auService;

	@Autowired
	public StudentRestController(StudentService service, AUService auService) {
		this.service = service;
		this.auService = auService;
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		List<Student> students = service.findAll();
		return students;
	}

	@PostMapping("/students")
	public Student addStudent(@RequestBody Student theStudent) {
		System.out.println(theStudent);
		theStudent.setId(0);

		Student dbStudent = service.save(theStudent);

		return dbStudent;
	}

	@GetMapping("/students/perSemester")
	public List<Student> getStudentsPerSemester(
			@RequestParam(value = "sem_id", required = true) int sem_id) {

		List<Registration> registrations = service.findBySemester(sem_id);

		List<Student> students = new ArrayList<>();

		for (Registration registration : registrations) {
			students.add(registration.getStudent());
		}
		return students;
	}

	@GetMapping("/students/perDepartmentAndSemester")
	public List<Student> getStudentsPerDepartmentAndSemester(
			@RequestParam(value = "department_name", required = true) Department department_name,
			@RequestParam(value = "sem_id", required = true) int sem_id) {

		AcademicUnit au = auService.findByDepartment(department_name);
		System.out.println(au.getId());
		List<Registration> registrations = service.findByDepartmentAndSemester(sem_id, au.getId());

		List<Student> students = new ArrayList<>();

		for (Registration registration : registrations) {
			students.add(registration.getStudent());
		}
		return students;
	}

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		Student theStudent = service.findById(studentId);

		if (theStudent == null) {
			throw new ResourceNotFoundException("student id not found - " + studentId);
		}

		return theStudent;
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
