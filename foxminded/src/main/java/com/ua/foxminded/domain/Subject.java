package com.ua.foxminded.domain;

public class Subject {

	private String name;
	
	public Subject(String name) {
		this.name = name;
	}
		
	public String getName() {
		return name;
	}

	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public String toString() {
		return name;
	}
}