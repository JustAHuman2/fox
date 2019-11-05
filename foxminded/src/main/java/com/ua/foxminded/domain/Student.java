package com.ua.foxminded.domain;

public class Student {

	private String name;
	private Group group;

	public Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Group getGroup() {
		return group;
	}

	public int hashCode() {
		return name.hashCode() * 31 + ((group == null) ? 0 : group.hashCode()) * 13;
	}

	@Override
	public String toString() {
		return "Student [" + name + ", groupId:" + group + "]";
	}
}