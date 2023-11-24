package com.irakozemaurice.registration.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "registrations")
public class Registration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	private LocalDate registrationDate;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "student_id")
	private Student student;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "semester_id")
	private Semester semester;

	@ManyToMany()
	@JoinTable(name = "course_registration", joinColumns = @JoinColumn(name = "registration_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> courses;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "au_id")
	private AcademicUnit academicUnit;

	public Registration() {
	}

	public Registration(LocalDate registrationDate) {
		super();
		this.registrationDate = registrationDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public AcademicUnit getAcademicUnit() {
		return academicUnit;
	}

	public void setAcademicUnit(AcademicUnit academicUnit) {
		this.academicUnit = academicUnit;
	}

	public void addCourse(Course course) {

		if (courses == null) {
			courses = new ArrayList<>();
		}

		courses.add(course);
	}

	@Override
	public String toString() {
		return "Registration [id=" + id + ", registrationDate=" + registrationDate +
				", student=" + student
				+ ", semester=" + semester + ", academicUnit=" + academicUnit + "]";
	}

}
