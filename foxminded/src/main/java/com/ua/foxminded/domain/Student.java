package com.ua.foxminded.domain;

public class Student {

	private String name;
	private int groupId;

	public Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getGroupId() {
		return groupId;
	}
	
	@Override
	public String toString() {
		return "Student [" + name + ", groupId:" + groupId + "]";
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() * 31 + groupId * 13;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Student) || (this.hashCode() != obj.hashCode()))
			return false;
		if (this == obj)
			return true;
		Student thatStudent = (Student) obj;
		if (this.getName().equals(thatStudent.getName())) {
			return true;
		}
		return false;
	}
}