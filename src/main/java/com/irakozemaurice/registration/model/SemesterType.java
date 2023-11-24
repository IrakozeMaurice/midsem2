package com.irakozemaurice.registration.model;

public enum SemesterType {

	SEMESTER_ONE("Semester One"),
	SEMESTER_TWO("Semester Two"),
	SUMMER("Summer Semester");

	private String name;

	SemesterType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
