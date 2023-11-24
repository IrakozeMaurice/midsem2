package com.irakozemaurice.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.irakozemaurice.registration.model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

}