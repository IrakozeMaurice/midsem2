package com.irakozemaurice.registration.service;

import java.util.List;

import com.irakozemaurice.registration.model.Course;

public interface CourseService {

	List<Course> findAll();

	Course save(Course s);

	Course findById(int id);

	void deleteById(int id);
}
