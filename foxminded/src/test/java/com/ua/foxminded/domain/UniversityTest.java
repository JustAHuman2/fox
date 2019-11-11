package com.ua.foxminded.domain;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class UniversityTest {

	private Subject math;
	private List<Subject> subjects;
	private Teacher teacherOne;
	private List<Teacher> teachers;
	private Auditory auditoryOne;
	private List<Auditory> auditories;
	private List<Student> students;
	private List<Group> groups;
	private LocalDate localDateOne;
	private LocalDate localDateTwo;
	private LocalDate localDateTree;
	private LocalDate localDateFour;
	private LessonTime lessonTime;
	private List<Lesson> schedule;
	private University university;

//	@Before
//	public void setup() {
//		math = new Subject("Math");
//		subjects = asList(math);
//		teacherOne = new Teacher("teacherOne", subjects);
//		teachers = asList(teacherOne, new Teacher("teacherTwo", subjects));
//		auditoryOne = new Auditory("auditoryOne", 90);
//		auditories = asList(auditoryOne, new Auditory("auditoryTwo", 50));
//		students = asList(new Student("StudentOne", 10), new Student("StudentTwo", 10));
//		groups = asList(new Group(10, students));
//		localDateOne = LocalDate.of(2019, Month.MAY, 11);
//		localDateTwo = LocalDate.of(2019, Month.MAY, 12);
//		localDateTree = LocalDate.of(2019, Month.MAY, 13);
//		localDateFour = LocalDate.of(2019, Month.MAY, 14);
//		lessonTime = new LessonTime(LocalTime.of(12, 00), LocalTime.of(13, 30));
//		schedule = asList(new Lesson(math, teacherOne, auditoryOne, groups, localDateOne, lessonTime),
//				new Lesson(math, teacherOne, auditoryOne, groups, localDateTwo, lessonTime),
//				new Lesson(math, teacherOne, auditoryOne, groups, localDateTree, lessonTime),
//				new Lesson(math, teacherOne, auditoryOne, groups, localDateFour, lessonTime));
//		university = new University("MIT", subjects, teachers, auditories, groups, schedule);
//	}

//	@Test
//	public void givenScheduleBiggerThenParameterRange_whenGetStudentSchedule_thenResultList() {
//		List<Lesson> expected = asList(new Lesson(math, teacherOne, auditoryOne, groups, localDateTwo, lessonTime),
//				new Lesson(math, teacherOne, auditoryOne, groups, localDateTree, lessonTime));
//
//		List<Lesson> actual = university.getStudentSchedule(localDateTwo, localDateFour);
//
//		assertEquals(expected, actual);
//	}
//
//	@Test
//	public void givenScheduleSameAsParameterRange_whenGetStudentSchedule_thenSchedule() {
//		List<Lesson> expected = schedule;
//
//		List<Lesson> actual = university.getStudentSchedule(localDateOne, LocalDate.of(2019, Month.MAY, 15));
//
//		assertEquals(expected, actual);
//	}
//
//	@Test
//	public void givenScheduleSmallerThenParameterRange_whenGetStudentSchedule_thenSchedule() {
//		List<Lesson> expected = schedule;
//
//		List<Lesson> actual = university.getStudentSchedule(localDateOne, LocalDate.of(2019, Month.JUNE, 26));
//
//		assertEquals(expected, actual);
//	}
//
//	@Test
//	public void givenMixedParameterDates_whenGetStudentSchedule_thenEmptyList() {
//		List<Lesson> expected = new ArrayList<>();
//
//		List<Lesson> actual = university.getStudentSchedule(LocalDate.of(2019, Month.MAY, 26),
//				LocalDate.of(2019, Month.MAY, 23));
//
//		assertEquals(expected, actual);
//	}
//
//	@Test(expected = NullPointerException.class)
//	public void givenNullFirstParameter_whenGetStudentSchedule_thenScheduleFromFirstParameter() {
//		university.getStudentSchedule(null, localDateOne);
//	}
//
//	@Test(expected = NullPointerException.class)
//	public void givenNullSecondParameter_whenGetStudentSchedule_thenScheduleFromFirstParameter() {
//		university.getStudentSchedule(localDateOne, null);
//	}
//
//	@Test
//	public void givenScheduleBiggerThenParameterRange_whenGetTeacherSchedule_thenResultList() {
//		List<Lesson> expected = asList(new Lesson(math, teacherOne, auditoryOne, groups, localDateOne, lessonTime));
//
//		List<Lesson> actual = university.getTeacherSchedule("teacherOne", localDateOne, localDateTwo);
//
//		assertEquals(expected, actual);
//	}
//
//	@Test
//	public void givenScheduleSameAsParameterRange_whenGetTeacherSchedule_thenSchedule() {
//		List<Lesson> expected = schedule;
//
//		List<Lesson> actual = university.getTeacherSchedule("teacherOne", localDateOne,
//				LocalDate.of(2019, Month.MAY, 15));
//
//		assertEquals(expected, actual);
//	}
//
//	@Test
//	public void givenScheduleSmallerThenParameterRange_whenGetTeacherSchedule_thenSchedule() {
//		List<Lesson> expected = schedule;
//
//		List<Lesson> actual = university.getTeacherSchedule("teacherOne", localDateOne,
//				LocalDate.of(2019, Month.JUNE, 26));
//
//		assertEquals(expected, actual);
//	}
//
//	@Test
//	public void givenMixedParameterDates_whenGetTeacherSchedule_thenEmptyList() {
//		List<Lesson> expected = new ArrayList<>();
//
//		List<Lesson> actual = university.getTeacherSchedule("teacherOne", LocalDate.of(2019, Month.MAY, 26),
//				LocalDate.of(2019, Month.MAY, 23));
//
//		assertEquals(expected, actual);
//	}
//
//	@Test
//	public void givenNullFirstParameter_whenGetTeacherSchedule_thenEmptyList() {
//		List<Lesson> expected = new ArrayList<>();
//
//		List<Lesson> actual = university.getTeacherSchedule(null, localDateOne, localDateTwo);
//
//		assertEquals(expected, actual);
//	}
//
//	@Test(expected = NullPointerException.class)
//	public void givenNullSecondParameter_whenGetTeacherSchedule_thenNPE() {
//		university.getTeacherSchedule("teacherOne", null, LocalDate.of(2019, Month.MAY, 23));
//	}
//
//	@Test(expected = NullPointerException.class)
//	public void givenNullThirdParameter_whenGetTeacherSchedule_thenNPE() {
//		university.getTeacherSchedule("teacherOne", localDateOne, null);
//	}

	@Test
	public void givenNulls_whenGetTeacherSchedule_thenEmptyList() {
		List<Lesson> expected = new ArrayList<>();

		List<Lesson> actual = university.getTeacherSchedule(null, null, null);

		assertEquals(expected, actual);
	}
}