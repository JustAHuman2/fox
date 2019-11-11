package com.ua.foxminded.domain;

import java.time.LocalDate;

public class Lesson {

	private Subject subject;
	private Teacher teacher;
	private Auditory auditory;
	private Group group;
	private LocalDate date;
	private LessonTime lessonTime;

	public Lesson(LocalDate date, LessonTime lessonTime, Auditory auditory) {
		this.date = date;
		this.lessonTime = lessonTime;
		this.auditory = auditory;
	}

	@Override
	public String toString() {
		return String.format("%-26s", teacher) + auditory + ", group:" + (null == group ? "null":group.getId() + " ") + ", date:" + date + ", " + lessonTime;
	}

	@Override
	public int hashCode() {
		return ((auditory == null) ? 0 : auditory.hashCode()) + ((date == null) ? 0 : date.hashCode())
				+ ((group == null) ? 0 : group.hashCode()) + ((lessonTime == null) ? 0 : lessonTime.hashCode())
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
				&& (this.getAuditory().equals(thatLesson.getAuditory())) && (this.group.equals(thatLesson.getGroup()))
				&& (this.date.equals(thatLesson.getDate())) && (this.lessonTime.equals(thatLesson.getLessonTime())))) {
			return true;
		}
		return false;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public Auditory getAuditory() {
		return auditory;
	}

	public LocalDate getDate() {
		return date;
	}

	public LessonTime getLessonTime() {
		return lessonTime;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Group getGroup() {
		return group;
	}
}