package com.irakozemaurice.registration.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "credits")
	private int credits;

	@ManyToMany()
	@JsonIgnore
	@JoinTable(name = "academicUnit_course", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "au_id"))
	private List<AcademicUnit> academicUnits;

	@ManyToMany()
	@JoinTable(name = "course_teacher", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "teacher_id"))
	private List<Teacher> teachers;

	@ManyToMany()
	@JsonIgnore
	@JoinTable(name = "course_registration", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "registration_id"))
	private List<Registration> registrations;

	public Course() {
	}

	public Course(String code, String name, String description, int credits) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
		this.credits = credits;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public List<AcademicUnit> getAcademicUnits() {
		return academicUnits;
	}

	public void setAcademicUnits(List<AcademicUnit> academicUnits) {
		this.academicUnits = academicUnits;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public List<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	public void addAcademicUnit(AcademicUnit academicUnit) {

		if (academicUnits == null) {
			academicUnits = new ArrayList<>();
		}

		academicUnits.add(academicUnit);
	}

	public void addTeacher(Teacher teacher) {

		if (teachers == null) {
			teachers = new ArrayList<>();
		}

		teachers.add(teacher);
		// teacher.getCourses().add(this);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description + ", credits="
				+ credits + "]";
	}

}
