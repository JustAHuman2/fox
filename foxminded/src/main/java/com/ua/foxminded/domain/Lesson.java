package com.ua.foxminded.domain;

import java.time.LocalDate;
import java.util.List;

public class Lesson {

	private Subject subject;
	private Teacher teacher;
	private Auditory auditory;
	private List<Group> groups;
	private LocalDate date;
	private LessonTime lessonTime;

	public Lesson(Subject subject, Teacher teacher, Auditory auditory, List<Group> groups, LocalDate date,
			LessonTime lessonTime) {
		this.subject = subject;
		this.teacher = teacher;
		this.auditory = auditory;
		this.groups = groups;
		this.date = date;
		this.lessonTime = lessonTime;
	}

	@Override
	public int hashCode() {
		return ((auditory == null) ? 0 : auditory.hashCode()) + ((date == null) ? 0 : date.hashCode())
				+ ((groups == null) ? 0 : groups.hashCode()) + ((lessonTime == null) ? 0 : lessonTime.hashCode())
				+ ((subject == null) ? 0 : subject.hashCode()) + ((teacher == null) ? 0 : teacher.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Lesson) || (this.hashCode() != obj.hashCode()))
			return false;
		if (this == obj)
			return true;
		Lesson thatLesson = (Lesson) obj;
		if ((this.getSubject().equals(thatLesson.getSubject()) && (this.getTeacher().equals(thatLesson.getTeacher()))
				&& (this.getAuditory().equals(thatLesson.getAuditory())) && (this.groups.equals(thatLesson.getGroups()))
				&& (this.date.equals(thatLesson.getDate())) && (this.lessonTime.equals(thatLesson.getLessonTime())))) {
			return true;
		}
		return false;
	}

	public Subject getSubject() {
		return subject;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public Auditory getAuditory() {
		return auditory;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public LocalDate getDate() {
		return date;
	}

	public LessonTime getLessonTime() {
		return lessonTime;
	}
}