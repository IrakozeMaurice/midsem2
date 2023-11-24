package com.irakozemaurice.registration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.irakozemaurice.registration.model.Registration;
import com.irakozemaurice.registration.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query("SELECT r FROM Registration r WHERE r.semester.id = :sem_id")
	List<Registration> findBySemester(@Param("sem_id") int sem_id);

	@Query("SELECT r FROM Registration r WHERE r.semester.id = :sem_id AND r.academicUnit.id = :au_id")
	List<Registration> findByDepartmentAndSemester(@Param("sem_id") int sem_id, @Param("au_id") int au_id);

	@Query("SELECT r FROM Registration r JOIN r.courses c WHERE r.semester.id = :sem_id AND c.id = :course_id")
	List<Registration> findByCourseAndSemester(@Param("sem_id") int sem_id, @Param("course_id") int course_id);
}
