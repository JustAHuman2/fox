package com.ua.foxminded.domain;

import static java.util.stream.Collectors.toList;
import java.time.LocalDate;
import java.util.List;

public class University {

	private List<Subject> subjects;
	private List<Teacher> teachers;
	private List<Group> groups;
	private List<Lesson> lessons;
	private List<Auditory> auditories;

	public University(List<Teacher> teachers, List<Group> groups, List<Auditory> auditories) {
		this.teachers = teachers;
		this.groups = groups;
		this.auditories = auditories;
	}

	public List<Lesson> getGroupSchedule(Group group, LocalDate from, LocalDate to) {
		return lessons.stream().filter(l -> l.getGroup().equals(group))
				.filter(l -> (l.getDate().equals(from) || l.getDate().isAfter(from)) && l.getDate().isBefore(to))
				.collect(toList());
	}

	public List<Lesson> getTeacherSchedule(Teacher teacher, LocalDate from, LocalDate to) {
		return lessons.stream().filter(l -> l.getTeacher().equals(teacher))
				.filter(l -> (l.getDate().equals(from) || l.getDate().isAfter(from)) && l.getDate().isBefore(to))
				.collect(toList());
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

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setAuditories(List<Auditory> auditories) {
		this.auditories = auditories;
	}

	public List<Auditory> getAuditories() {
		return auditories;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

	public List<Lesson> getLessons() {
		return lessons;
	}
}