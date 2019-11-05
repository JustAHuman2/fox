package com.ua.foxminded.domain;

import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.util.List;

public class University {

	private String name;
	private List<Subject> subjects;
	private List<Teacher> teachers;
	private List<Auditory> auditories;
	private List<Group> groups;
	private List<Lesson> schedule;
	
	public University(String name, List<Subject> subjects, List<Teacher> teachers, List<Auditory> auditories,
			List<Group> groups, List<Lesson> schedule) {
		this.name = name;
		this.subjects = subjects;
		this.teachers = teachers;
		this.auditories = auditories;
		this.groups = groups;
		this.schedule = schedule;
	}
	public List<Lesson> getGroupSchedule(Group group, LocalDate from, LocalDate to) {
		return schedule.stream().filter(l -> l.getGroups().contains(group))
				.filter(l -> l.getDate().equals(from) || l.getDate().isAfter(from) && l.getDate().isBefore(to))
				.collect(toList());
	}

	public List<Lesson> getTeacherSchedule(Teacher teacher, LocalDate from, LocalDate to) {
		return schedule.stream().filter(l -> l.getTeacher().equals(teacher))
				.filter(l -> l.getDate().equals(from) || l.getDate().isAfter(from) && l.getDate().isBefore(to))
				.collect(toList());
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setAuditeories(List<Auditory> auditeories) {
		this.auditories = auditeories;
	}

	public List<Auditory> getAuditeories() {
		return auditories;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setSchedule(List<Lesson> schedule) {
		this.schedule = schedule;
	}

	public List<Lesson> getSchedule() {
		return schedule;
	}
}