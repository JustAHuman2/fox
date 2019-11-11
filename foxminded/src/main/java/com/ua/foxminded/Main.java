package com.ua.foxminded;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import com.ua.foxminded.domain.Lesson;
import com.ua.foxminded.domain.LessonTime;
import com.ua.foxminded.domain.Student;
import com.ua.foxminded.domain.University;

import schedule.Schedule;

public class Main {

	public static void main(String[] args) {
	University university = new University();
		try {
			university.setTeachers(university.generateTeachers("teachers.txt"));
			university.setSubjects(university.getTeachers().stream().map(t -> t.getSubject()).collect(toList()));		
			university.setGroups(university.generateGroups("groups.txt"));
			List<Student> students = university.generateStudents("students.txt");
			students.forEach(s -> university.assignToGroup(s, university.getGroups()));
			university.setAuditories(university.generateAuditories("auditories.txt"));
			Schedule schedule = new Schedule();
			List<LessonTime> daySchedule = schedule.getDaySchedule();
			List<LocalDate> academicDays = university.getAcademicDays(LocalDate.of(2019, 9, 01),
					LocalDate.of(2019, 12, 30));
			List<Lesson> lessons = schedule.getSchedule(academicDays, daySchedule, university.getAuditories());
			lessons = schedule.setTeachers(lessons, university.getTeachers(), university.getAuditories());
			lessons = schedule.setGroups(lessons, university.getGroups(), university.getAuditories());
			university.setLessons(lessons);
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Menu menu = new Menu();
			Scanner scanner = new Scanner(System.in);
			int number = 0;
			while (true) {
				System.out.println(Menu.MENU);
				number = scanner.nextInt();
				if (number == 6) {
					break;
				}
				System.out.println(menu.showMenu(number, university.getTeachers(), university.getSubjects(), university.getGroups()));
				if (number == 4 || number == 5) {
					String input = reader.readLine();
					System.out.println(menu.executeCommand(number, input, university.getTeachers(), university.getSubjects(), university.getGroups()));
				}
			}
			scanner.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}