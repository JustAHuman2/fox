package com.ua.foxminded.domain;

public class Teacher {

	private String name;
	private Subject subject;

	public Teacher(String name, Subject subject) {
		this.name = name;
		this.subject = subject;
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
		return String.format("%-16s %-11s", name, subject);
	}

	@Override
	public int hashCode() {
		return name.hashCode() * 31 + ((subject == null) ? 0 : subject.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Teacher) || this.hashCode() != obj.hashCode())
			return false;
		if (this == obj)
			return true;
		Teacher thatTeacher = (Teacher) obj;
		if ((this.getName() == thatTeacher.getName()) && this.getSubject() == thatTeacher.getSubject()) {
			return true;
		}
		return false;
	}
}