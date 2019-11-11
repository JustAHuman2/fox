package com.ua.foxminded.domain;

public class Auditory {

	private String name;
	private int capacity;

	public Auditory(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
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
		return "[" + name + ", capacity:" + capacity + "]";
	}
}