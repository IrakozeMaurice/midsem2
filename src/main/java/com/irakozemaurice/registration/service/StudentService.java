package com.irakozemaurice.registration.service;

import java.util.List;

import com.irakozemaurice.registration.model.Registration;
import com.irakozemaurice.registration.model.Student;

public interface StudentService {

	List<Student> findAll();

	List<Registration> findBySemester(int sem_id);

	List<Registration> findByDepartmentAndSemester(int au_id, int sem_id);

	Student save(Student theStudent);

	Student findById(int theId);

	void deleteById(int theId);
}
