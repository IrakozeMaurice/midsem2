package com.irakozemaurice.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irakozemaurice.registration.model.Semester;

public interface SemesterRepository extends JpaRepository<Semester, Integer> {

	// will inherit all crud methods for dao
}
