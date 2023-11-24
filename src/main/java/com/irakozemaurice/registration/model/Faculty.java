package com.irakozemaurice.registration.model;

public enum Faculty {

	IT("Information Technology"),
	BUSINESS_ADMINISTRATION("Business Administration"),
	EDUCATION("Education"),
	MBA("Masters of Business Administration"),
	BIG_DATA("Masters of Science in Big Data Analytics"),
	MA_EDUCATION("Masters of Arts in Education");

	private String name;

	Faculty(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
