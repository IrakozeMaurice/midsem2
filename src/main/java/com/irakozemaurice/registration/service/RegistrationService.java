package com.irakozemaurice.registration.service;

import java.util.List;

import com.irakozemaurice.registration.model.Registration;

public interface RegistrationService {

	List<Registration> findAll();

	Registration save(Registration s);

	Registration findById(int id);

}
