package com.irakozemaurice.registration.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "academic_units")
public class AcademicUnit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@Enumerated(EnumType.STRING)
	private Program program;

	@Enumerated(EnumType.STRING)
	private Faculty faculty;

	@Enumerated(EnumType.STRING)
	private Department department;

	@JsonManagedReference
	@JsonIgnore
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "au_id")
	private List<Student> students;

	@JsonManagedReference
	@JsonIgnore
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "au_id")
	private List<Registration> registrations;

	@ManyToMany()
	@JsonIgnore
	@JoinTable(name = "academicUnit_course", joinColumns = @JoinColumn(name = "au_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> courses;

	public AcademicUnit() {
	}

	public AcademicUnit(String code, String name, Program program, Faculty faculty, Department department) {
		super();
		this.code = code;
		this.name = name;
		this.program = program;
		this.faculty = faculty;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public void addStudent(Student student) {

		if (students == null) {

			students = new ArrayList<>();

		}

		students.add(student);
	}

	public void addRegistration(Registration registration) {

		if (registrations == null) {

			registrations = new ArrayList<>();

		}

		registrations.add(registration);
	}

	public void addCourse(Course course) {

		if (courses == null) {

			courses = new ArrayList<>();

		}

		courses.add(course);
	}

	@Override
	public String toString() {
		return "AcademicUnit [id=" + id + ", code=" + code + ", name=" + name + ", program=" + program + ", faculty="
				+ faculty + ", department=" + department + "]";
	}

}
