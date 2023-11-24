package com.irakozemaurice.registration.model;

import java.time.LocalDate;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "semesters")
public class Semester {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Enumerated(EnumType.STRING)
	private SemesterType type;

	@Temporal(TemporalType.DATE)
	private LocalDate startDate;

	@Temporal(TemporalType.DATE)
	private LocalDate endDate;

	@JsonManagedReference
	@JsonIgnore
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "semester_id")
	private List<Registration> registrations;

	public Semester() {
	}

	public Semester(String name, SemesterType type, LocalDate startDate, LocalDate endDate) {
		super();
		this.name = name;
		this.type = type;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SemesterType getType() {
		return type;
	}

	public void setType(SemesterType type) {
		this.type = type;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public List<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	@Override
	public String toString() {
		return "Semester [id=" + id + ", name=" + name + ", type=" + type + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}

}
