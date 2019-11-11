package com.ua.foxminded.domain;

import java.util.ArrayList;
import java.util.List;

public class Group {

	private int id;
	private List<Student> students = new ArrayList<>();

	public Group(int id) {
		this.id = id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Student> getStudents() {
		return students;
	}

	@Override
	public String toString() {
		return "Group [id:" + id + ", students:" + students + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Group))
			return false;
		if (this == obj)
			return true;
		Group thatGroup = (Group) obj;
		if (this.getId() == (thatGroup.getId())) {
			return true;
		}
		return false;
	}
}