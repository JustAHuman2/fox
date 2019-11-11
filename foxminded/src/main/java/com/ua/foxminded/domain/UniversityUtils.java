package com.ua.foxminded.domain;

import static java.util.Arrays.asList;
import static java.util.concurrent.ThreadLocalRandom.current;
import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import com.ua.foxminded.domain.Auditory;
import com.ua.foxminded.domain.Group;
import com.ua.foxminded.domain.Student;
import com.ua.foxminded.domain.Subject;
import com.ua.foxminded.domain.Teacher;

public class UniversityUtils {

	public List<Group> generateGroups(int firstNumber, int lastNumber) {
		return IntStream.range(firstNumber, lastNumber).mapToObj(i -> new Group(i)).collect(toList());
	}

	public List<Auditory> generateAuditories(int firstNumber, int lastNumber) {
		return IntStream.range(firstNumber, lastNumber).mapToObj(i -> new Auditory(i, 20)).collect(toList());
	}

	public List<Student> generateStudents() {
		return asList(new Student("Andrew Arns"), new Student("Dean Berns"), new Student("John Black"),
				new Student("Jim White"), new Student("Andie Kit"), new Student("Dan Cole"));
	}

	public List<Teacher> generateTeachers() {
		return asList(new Teacher("Bob Dean", new Subject("Math")), new Teacher("Kim Chen", new Subject("Latin")),
				new Teacher("John Ant", new Subject("Chemistry")));
	}

	public Student assignToGroup(Student student, List<Group> groups) {
		Group group = groups.get(current().nextInt(groups.size()));
		group.getStudents().add(student);
		student.setGroupId(group.getId());
		return student;
	}

	public List<LocalDate> getAcademicDays(LocalDate startDate, LocalDate endDate) {
		return IntStream.iterate(0, i -> i + 1).limit(ChronoUnit.DAYS.between(startDate, endDate))
				.mapToObj(startDate::plusDays).filter(d -> d.getDayOfWeek().name() != "SUNDAY")
				.collect(Collectors.toList());
	}
}