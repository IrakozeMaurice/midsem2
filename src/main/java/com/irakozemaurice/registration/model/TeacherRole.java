package com.irakozemaurice.registration.model;

public enum TeacherRole {

	TUTOR("Tutor"),
	ASSISTANT("Assistant");

	private String name;

	TeacherRole(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
