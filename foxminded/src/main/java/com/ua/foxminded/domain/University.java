package com.ua.foxminded.domain;

import static java.nio.file.Files.lines;
import static java.util.concurrent.ThreadLocalRandom.current;
import static java.util.stream.Collectors.toList;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class University {

	private List<Subject> subjects;
	private List<Teacher> teachers;
	private List<Group> groups;
	private List<Lesson> lessons;
	private List<Auditory> auditories;
	
	public University() {
	}

	public University(List<Teacher> teachers, List<Subject> subjects, List<Group> groups) {
		this.subjects = subjects;
		this.teachers = teachers;
		this.groups = groups;
	}

	public List<Lesson> getGroupSchedule(Group group, LocalDate from, LocalDate to) {
		return lessons.stream().filter(l -> l.getGroup().equals(group))
				.filter(l -> l.getDate().equals(from) || l.getDate().isAfter(from) && l.getDate().isBefore(to))
				.collect(toList());
	}

	public List<Lesson> getTeacherSchedule(Teacher teacher, LocalDate from, LocalDate to) {
		return lessons.stream().filter(l -> l.getTeacher().equals(teacher))
				.filter(l -> l.getDate().equals(from) || l.getDate().isAfter(from) && l.getDate().isBefore(to))
				.collect(toList());
	}

	public List<Group> generateGroups(String groups) throws IOException {
		return readFile(groups).map(g -> new Group(Integer.parseInt(g))).collect(toList());
	}

	public List<Auditory> generateAuditories(String auditories) throws IOException {
		return readFile(auditories).map(
				l -> new Auditory(l.substring(0, l.indexOf(" ")), Integer.parseInt(l.substring(l.indexOf(" ") + 1))))
				.collect(toList());
	}

	public List<Student> generateStudents(String students) throws IOException {
		return readFile(students).map(s -> new Student(s)).collect(toList());
	}

	public Student assignToGroup(Student student, List<Group> groups) {
		Group group = groups.get(current().nextInt(groups.size()));
		group.getStudents().add(student);
		student.setGroupId(group.getId());
		return student;
	}

	public Stream<String> readFile(String fileName) throws IOException {
		return lines(new File(ClassLoader.getSystemClassLoader().getResource(fileName).getFile()).toPath());
	}

	public List<LocalDate> getAcademicDays(LocalDate startDate, LocalDate endDate) {
		return IntStream.iterate(0, i -> i + 1).limit(ChronoUnit.DAYS.between(startDate, endDate))
				.mapToObj(startDate::plusDays).filter(d -> d.getDayOfWeek().name() != "SUNDAY")
				.collect(Collectors.toList());
	}

	public List<Teacher> generateTeachers(String teachers) throws IOException {
		return readFile(teachers)
				.map(t -> new Teacher(t.substring(0, t.indexOf(":")), new Subject(t.substring(t.indexOf(":") + 1))))
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