package com.irakozemaurice.registration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irakozemaurice.registration.model.AcademicUnit;
import com.irakozemaurice.registration.model.Department;
import com.irakozemaurice.registration.repository.AURepository;

@Service
public class AUServiceImpl implements AUService {

	private AURepository auRepository;

	@Autowired
	public AUServiceImpl(AURepository auDao) {
		this.auRepository = auDao;
	}

	@Override
	public List<AcademicUnit> findAll() {
		return auRepository.findAll();
	}

	public AcademicUnit save(AcademicUnit au) {
		return auRepository.save(au);
	}

	@Override
	public AcademicUnit findById(int theId) {

		Optional<AcademicUnit> result = auRepository.findById(theId);

		if (result.isPresent()) {
			AcademicUnit theAU = result.get();
			return theAU;
		}
		return null;
	}

	@Override
	public AcademicUnit findByDepartment(Department department_name) {

		Optional<AcademicUnit> result = auRepository.findByDepartment(department_name);

		if (result.isPresent()) {
			AcademicUnit theAU = result.get();
			return theAU;
		}
		return null;
	}

	@Override
	public void deleteById(int theId) {
		auRepository.deleteById(theId);
	}

}
