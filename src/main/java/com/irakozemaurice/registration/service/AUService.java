package com.irakozemaurice.registration.service;

import java.util.List;

import com.irakozemaurice.registration.model.AcademicUnit;
import com.irakozemaurice.registration.model.Department;

public interface AUService {

	List<AcademicUnit> findAll();

	AcademicUnit save(AcademicUnit au);

	AcademicUnit findById(int id);

	AcademicUnit findByDepartment(Department department_name);

}
