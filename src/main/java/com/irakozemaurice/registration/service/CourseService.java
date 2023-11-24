package com.irakozemaurice.registration.service;

import java.util.List;

import com.irakozemaurice.registration.model.Course;

public interface CourseService {

	List<Course> findAll();

	List<Course> findByStudent(int student_id);

	List<Course> findByDepartmentAndSemester(int sem_id, int au_id);

	Course save(Course s);

	Course findById(int id);

}
