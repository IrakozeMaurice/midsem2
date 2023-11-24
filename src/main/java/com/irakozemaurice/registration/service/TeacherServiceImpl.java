package com.irakozemaurice.registration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irakozemaurice.registration.model.Teacher;
import com.irakozemaurice.registration.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {

	private TeacherRepository repository;

	@Autowired
	public TeacherServiceImpl(TeacherRepository dao) {

		this.repository = dao;

	}

	@Override
	public List<Teacher> findAll() {

		return repository.findAll();

	}

	public Teacher save(Teacher teacher) {

		return repository.save(teacher);

	}

	@Override
	public Teacher findById(int theId) {

		Optional<Teacher> result = repository.findById(theId);

		if (result.isPresent()) {

			Teacher theTeacher = result.get();

			return theTeacher;

		}

		return null;

	}

}
