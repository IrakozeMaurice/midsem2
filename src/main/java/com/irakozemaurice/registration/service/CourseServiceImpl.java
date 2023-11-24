package com.irakozemaurice.registration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irakozemaurice.registration.model.Course;
import com.irakozemaurice.registration.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	private CourseRepository repository;

	@Autowired
	public CourseServiceImpl(CourseRepository dao) {
		this.repository = dao;
	}

	@Override
	public List<Course> findAll() {
		return repository.findAll();
	}

	public Course save(Course course) {
		return repository.save(course);
	}

	@Override
	public Course findById(int theId) {

		Optional<Course> result = repository.findById(theId);

		if (result.isPresent()) {
			Course theCourse = result.get();
			return theCourse;
		}
		return null;
	}

	@Override
	public void deleteById(int theId) {
		repository.deleteById(theId);
	}

}
