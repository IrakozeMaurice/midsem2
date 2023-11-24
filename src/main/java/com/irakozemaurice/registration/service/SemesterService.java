package com.irakozemaurice.registration.service;

import java.util.List;

import com.irakozemaurice.registration.model.Semester;

public interface SemesterService {

	List<Semester> findAll();

	Semester save(Semester s);

	Semester findById(int id);

}
