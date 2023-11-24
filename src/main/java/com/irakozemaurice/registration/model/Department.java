package com.irakozemaurice.registration.model;

public enum Department {

	SOFTWARE_ENGINEERING("Software Engineering"),
	NETWORKS_AND_COMMUNICATION_SYSTEMS("Networks and Communication Systems"),
	INFORMATION_MANAGEMENT("Information Management"),

	FINANCE("Finance"),
	MARKETING("Marketing"),
	ACCOUNTING("Accounting"),
	MANAGEMENT("Management"),

	EDUCATION_HISTORY("Education with History"),
	EDUCATION_SCIENCE("Education with Science"),

	MBA("Masters of Business Administration"),
	BIG_DATA("Masters of Science in Big Data Analytics"),
	MA_EDUCATION("Masters of Arts in Education");

	private String name;

	Department(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
