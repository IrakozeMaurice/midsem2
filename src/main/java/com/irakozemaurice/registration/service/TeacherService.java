package com.irakozemaurice.registration.service;

import java.util.List;

import com.irakozemaurice.registration.model.Teacher;

public interface TeacherService {

	List<Teacher> findAll();

	Teacher save(Teacher s);

	Teacher findById(int id);

	void deleteById(int id);
}
