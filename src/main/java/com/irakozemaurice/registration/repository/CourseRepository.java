package com.irakozemaurice.registration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.irakozemaurice.registration.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	@Query("SELECT c FROM Registration r JOIN r.courses c WHERE r.student.id = :student_id")
	List<Course> findByStudent(@Param("student_id") int student_id);

	@Query("SELECT c FROM Registration r JOIN r.courses c WHERE r.semester.id = :sem_id AND r.academicUnit.id = :au_id")
	List<Course> findByDepartmentAndSemester(@Param("sem_id") int sem_id, @Param("au_id") int au_id);

}
