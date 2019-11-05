package com.ua.foxminded;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.ua.foxminded.domain.Auditory;
import com.ua.foxminded.domain.Group;
import com.ua.foxminded.domain.Student;
import com.ua.foxminded.domain.Subject;
import com.ua.foxminded.domain.Teacher;

public class Main {

	public static void main(String[] args) {
		ContentGenerator contentGenerator = new ContentGenerator();

			try {
				List<Subject> subjects = contentGenerator.generateSubjects("subjects.txt");
//				subjects.forEach(s -> System.out.println(s));
			
				List<Teacher> teachers = contentGenerator.generateTeachers("teachers.txt");
//				teachers.forEach(s -> System.out.println(s));
				
				List<Student> students = contentGenerator.generateStudents("students.txt");
//				students.forEach(s -> System.out.println(s));
				
				List<Auditory> auditories = contentGenerator.generateAuditories("auditories.txt");
				auditories.forEach(s -> System.out.println(s));
		
//			List<Group> groups = generator.generateGroups("groups.txt").stream().map(g -> groupDao.create(g))
//					.collect(toList());
//			List<Teacher> teachers = generator.generateCourses("courses.txt").stream().peek(c -> courseDao.create(c))
//					.collect(toList());
//		
//			generator.generateStudents("studentFirstNames.txt", "studentLastNames.txt", groups, courses, 200).stream()
//					.peek(s -> studentDao.create(s))
//					.forEach(s -> s.getCourses().forEach(c -> courseDao.addStudent(s.getId(), c.getId())));
//			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//			Menu menu = new Menu();
//			Scanner scanner = new Scanner(System.in);
//			int number = 0;
//			while (true) {
//				System.out.println(Menu.MENU);
//				number = scanner.nextInt();
//				if (number == 6) {
//					break;
//				}
//				System.out.println(menu.showMenu(number));
//				String input;
//				input = reader.readLine();
//				System.out.println(menu.executeCommand(number, input));
//			}
//			scanner.close();
//			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}