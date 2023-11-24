package com.irakozemaurice.registration.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "names")
	private String names;

	@Enumerated(EnumType.STRING)
	private TeacherRole role;

	@Column(name = "qualification")
	private String qualification;

	@ManyToMany()
	@JsonIgnore
	@JoinTable(name = "course_teacher", joinColumns = @JoinColumn(name = "teacher_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> courses;

	public Teacher() {
	}

	public Teacher(String names, TeacherRole role, String qualification) {
		super();
		this.names = names;
		this.role = role;
		this.qualification = qualification;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public TeacherRole getRole() {
		return role;
	}

	public void setRole(TeacherRole role) {
		this.role = role;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public void addCourse(Course course) {

		if (courses == null) {
			courses = new ArrayList<>();
		}

		courses.add(course);
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", names=" + names + ", role=" + role + ", qualification=" + qualification + "]";
	}

}
