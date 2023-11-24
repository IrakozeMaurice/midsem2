package com.irakozemaurice.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irakozemaurice.registration.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	// will inherit all crud methods for dao
}
