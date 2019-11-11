package com.ua.foxminded.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.ua.foxminded.domain.Auditory;
import com.ua.foxminded.domain.Group;
import com.ua.foxminded.domain.Lesson;
import com.ua.foxminded.domain.LessonTime;
import com.ua.foxminded.domain.Teacher;

public class Schedule {

	public List<LessonTime> getDaySchedule() {
		return Arrays.asList(new LessonTime(LocalTime.of(8, 30), LocalTime.of(10, 00)),
				new LessonTime(LocalTime.of(10, 15), LocalTime.of(11, 45)),
				new LessonTime(LocalTime.of(12, 00), LocalTime.of(13, 30)),
				new LessonTime(LocalTime.of(14, 15), LocalTime.of(15, 45)),
				new LessonTime(LocalTime.of(16, 00), LocalTime.of(17, 30)),
				new LessonTime(LocalTime.of(17, 45), LocalTime.of(19, 15)));
	}

	public List<Lesson> getSchedule(List<LocalDate> academicDays, List<LessonTime> daySchedule,
			List<Auditory> auditories) {
		List<Lesson> table = new ArrayList<>();
		for (LocalDate day : academicDays) {
			for (LessonTime lessonTime : daySchedule) {
				for (Auditory auditory : auditories) {
					table.add(new Lesson(day, lessonTime, auditory));
				}
			}
		}
		return table;
	}

	public List<Lesson> setTeachers(List<Lesson> lessons, List<Teacher> teachers, List<Auditory> auditories) {
		for (Teacher teacher : teachers) {
			for (int i = 0; i < lessons.size(); i++) {
				Lesson lesson = lessons.get(i);
				if (lesson.getTeacher() == null) {
					lesson.setTeacher(teacher);
					lesson.setSubject(teacher.getSubject());
					int index = auditories.size() - i % auditories.size();
					i = i + index - 1;
				}
			}
		}
		return lessons;
	}

	public List<Lesson> setGroups(List<Lesson> lessons, List<Group> groups, List<Auditory> auditories) {
		for (Group group : groups) {
			for (int i = 0; i < lessons.size(); i++) {
				Lesson lesson = lessons.get(i);
				if (lesson.getGroup() == null) {
					lesson.setGroup(group);
					int index = auditories.size() - i % auditories.size();
					i = i + index - 1;
				}
			}
		}
		return lessons;
	}
}