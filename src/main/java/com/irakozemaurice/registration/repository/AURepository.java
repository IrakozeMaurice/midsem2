package com.irakozemaurice.registration.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.irakozemaurice.registration.model.AcademicUnit;
import com.irakozemaurice.registration.model.Department;

public interface AURepository extends JpaRepository<AcademicUnit, Integer> {

	@Query("SELECT au FROM AcademicUnit au WHERE au.department = :department_name")
	Optional<AcademicUnit> findByDepartment(@Param("department_name") Department department_name);
}
