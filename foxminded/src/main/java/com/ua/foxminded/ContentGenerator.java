package com.ua.foxminded;

import static java.nio.file.Files.lines;
import static java.util.stream.Collectors.toList;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import com.ua.foxminded.domain.Auditory;
import com.ua.foxminded.domain.Group;
import com.ua.foxminded.domain.Student;
import com.ua.foxminded.domain.Subject;
import com.ua.foxminded.domain.Teacher;

public class ContentGenerator {

	public List<Subject> generateSubjects(String subjects) throws IOException {
		return readFile(subjects).map(s -> new Subject(s)).collect(toList());

//				readFile(subjects)
//				.map(line -> new Subject(line.substring(0, line.indexOf(' ')).trim()))
//				.collect(toList());
	}

	public List<Teacher> generateTeachers(String teachers) throws IOException {
		return readFile(teachers).map(t -> new Teacher(t)).collect(toList());
	}

	public List<Student> generateStudents(String students) throws IOException {
		return readFile(students).map(s -> new Student(s)).collect(toList());
	}

	public Stream<String> readFile(String fileName) throws IOException {
		return lines(new File(ClassLoader.getSystemClassLoader().getResource(fileName).getFile()).toPath());
	}

	public List<Auditory> generateAuditories(String auditories) throws IOException {
		return readFile(auditories)
				.map(line -> new Auditory(line.substring(0, line.indexOf(',')), line.substring(line.indexOf(',')))).collect(toList());
	}

}