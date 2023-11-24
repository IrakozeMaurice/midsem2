package com.irakozemaurice.registration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irakozemaurice.registration.model.Registration;
import com.irakozemaurice.registration.model.Student;
import com.irakozemaurice.registration.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository repository;

	@Autowired
	public StudentServiceImpl(StudentRepository studentDao) {
		this.repository = studentDao;
	}

	@Override
	public List<Student> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Registration> findBySemester(int sem_id) {
		return repository.findBySemester(sem_id);
	}

	@Override
	public List<Registration> findByDepartmentAndSemester(int au_id, int sem_id) {
		return repository.findByDepartmentAndSemester(au_id, sem_id);
	}

	public Student save(Student theStudent) {
		System.out.println(theStudent);
		return repository.save(theStudent);
	}

	@Override
	public Student findById(int theId) {

		Optional<Student> result = repository.findById(theId);

		Student theStudent = null;
		if (result.isPresent()) {
			theStudent = result.get();
			return theStudent;
		}

		return null;
	}

	@Override
	public void deleteById(int theId) {
		repository.deleteById(theId);
	}

}
