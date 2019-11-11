package com.ua.foxminded.domain;

import java.util.ArrayList;
import java.util.List;

public class Teacher {

	private String name;
	private List<Subject> subjects = new ArrayList<>();
	private Subject subject;

	public Teacher(String name, Subject subject) {
		this.name = name;
		this.subject = subject;
	}

	public String getName() {
		return name;
	}

	public Subject getSubject() {
		return subject;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}
	
	public int hashCode() {
		return name.hashCode() * 31 + ((subjects == null) ? 0 : subjects.hashCode());
	}

	@Override
	public String toString() {
		return  String.format("%-16s %-11s", name, subject);
	}
}