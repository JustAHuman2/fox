package com.ua.foxminded.domain;

import java.util.List;

public class Group {

	private int id;
	private List<Student> students;

	public Group(int id, List<Student> students) {
		this.id = id;
		this.students = students;
	}

	public Group(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public List<Student> getStudents() {
		return students;
	}

	@Override
	public int hashCode() {
		return 31 * id + ((students == null) ? 0 : students.hashCode());
	}
}