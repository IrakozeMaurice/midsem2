package com.irakozemaurice.registration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irakozemaurice.registration.model.Semester;
import com.irakozemaurice.registration.repository.SemesterRepository;

@Service
public class SemesterServiceImpl implements SemesterService {

	private SemesterRepository repository;

	@Autowired
	public SemesterServiceImpl(SemesterRepository dao) {

		this.repository = dao;

	}

	@Override
	public List<Semester> findAll() {

		return repository.findAll();

	}

	public Semester save(Semester semester) {

		return repository.save(semester);

	}

	@Override
	public Semester findById(int theId) {

		Optional<Semester> result = repository.findById(theId);

		if (result.isPresent()) {

			Semester theSemester = result.get();

			return theSemester;

		}

		return null;
	}

}
