package com.irakozemaurice.registration.service;

import java.util.List;

import com.irakozemaurice.registration.model.Registration;
import com.irakozemaurice.registration.model.Student;

public interface StudentService {

	List<Student> findAll();

	List<Registration> findBySemester(int sem_id);

	List<Registration> findByDepartmentAndSemester(int sem_id, int au_id);

	List<Registration> findByCourseAndSemester(int sem_id, int course_id);

	Student save(Student theStudent);

	Student findById(int theId);

}
