package com.irakozemaurice.registration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irakozemaurice.registration.model.Registration;
import com.irakozemaurice.registration.model.Student;
import com.irakozemaurice.registration.repository.RegistrationRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	private RegistrationRepository repository;

	@Autowired
	public RegistrationServiceImpl(RegistrationRepository dao) {
		this.repository = dao;
	}

	@Override
	public List<Registration> findAll() {
		return repository.findAll();
	}

	// @Override
	// public List<Registration> findBySemester(int sem_id) {
	// return repository.findBySemester(sem_id);
	// }

	public Registration save(Registration registration) {
		return repository.save(registration);
	}

	@Override
	public Registration findById(int theId) {

		Optional<Registration> result = repository.findById(theId);

		if (result.isPresent()) {
			Registration theRegistration = result.get();
			return theRegistration;
		}
		return null;
	}

	@Override
	public void deleteById(int theId) {
		repository.deleteById(theId);
	}

}
