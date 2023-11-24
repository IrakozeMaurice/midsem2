package com.irakozemaurice.registration.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "students")
public class Student implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "reg_no")
	private String regNo;

	@Column(name = "student_names")
	private String studentNames;

	@Temporal(TemporalType.DATE)
	private LocalDate dateOfBirth;

	@JsonBackReference
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "au_id")
	private AcademicUnit academicUnit;

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	private List<Registration> registrations;

	public Student() {
	}

	public Student(String regNo, String studentNames, LocalDate dateOfBirth) {
		super();
		this.regNo = regNo;
		this.studentNames = studentNames;
		this.dateOfBirth = dateOfBirth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getStudentNames() {
		return studentNames;
	}

	public void setStudentNames(String studentNames) {
		this.studentNames = studentNames;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	public void addRegistration(Registration registration) {

		if (registrations == null) {
			registrations = new ArrayList<>();
		}

		registrations.add(registration);

		registration.setStudent(this);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", regNo=" + regNo + ", studentNames=" + studentNames + ", dateOfBirth="
				+ dateOfBirth + "]";
	}

	public AcademicUnit getAcademicUnit() {
		return academicUnit;
	}

	public void setAcademicUnit(AcademicUnit academicUnit) {
		this.academicUnit = academicUnit;
	}

}
