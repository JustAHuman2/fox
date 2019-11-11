package com.ua.foxminded.domain;

public class Teacher {

	private String name;
	private Subject subject;

	public Teacher(String name, Subject subject) {
		this.name = name;
		this.subject = subject;
	}

	public Teacher(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Subject getSubject() {
		return subject;
	}

	@Override
	public String toString() {
		return name + ", Subjects: " + subject;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Teacher))
			return false;
		if (this == obj)
			return true;
		Teacher thatTeacher = (Teacher) obj;
		return this.getName() == thatTeacher.getName();
	}
}