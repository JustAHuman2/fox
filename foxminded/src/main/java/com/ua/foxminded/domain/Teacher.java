package com.ua.foxminded.domain;

import java.util.List;

public class Teacher {

	private String name;
	private List<Subject> subjects;

	public Teacher(String name, List<Subject> subjects) {
		this.name = name;
		this.subjects = subjects;
	}

	public Teacher(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public int hashCode() {
		return name.hashCode() * 31 + ((subjects == null) ? 0 : subjects.hashCode());
	}

	@Override
	public String toString() {
		return "Teacher ["+ name + ", subjects:" + subjects + "]";
	}
}