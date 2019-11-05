package com.ua.foxminded.domain;

public class Auditory {

	private String name;
	private int capacity;
	
	private String testcapacity;

	public Auditory(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
	}

	public Auditory(String name) {
		this.name = name;
	}

	public Auditory(String name, String testcapacity) {
		this.name = name;
		this.testcapacity = testcapacity;
	}

	public String getName() {
		return name;
	}

	public int getCapacity() {
		return capacity;
	}

	public int hashCode() {
		return name.hashCode() + capacity * 31;
	}

	@Override
	public String toString() {
		return "Auditory [" + name + ", capacity=" + capacity + "]";
	}
}