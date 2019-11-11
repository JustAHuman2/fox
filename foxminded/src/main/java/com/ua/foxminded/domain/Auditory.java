package com.ua.foxminded.domain;

public class Auditory {

	private int name;
	private int capacity;

	public Auditory(int name, int capacity) {
		this.name = name;
		this.capacity = capacity;
	}

	public void setName(int name) {
		this.name = name;
	}

	public int getName() {
		return name;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	@Override
	public int hashCode() {
		return name * 17 + capacity * 31;
	}

	@Override
	public String toString() {
		return "[" + name + ", capacity:" + capacity + "]";
	}
}