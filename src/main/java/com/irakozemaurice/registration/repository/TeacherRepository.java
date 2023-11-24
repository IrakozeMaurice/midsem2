package com.irakozemaurice.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irakozemaurice.registration.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

	// will inherit all crud methods for dao
}
