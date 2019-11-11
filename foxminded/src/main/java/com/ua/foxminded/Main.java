package com.ua.foxminded;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import com.ua.foxminded.domain.Lesson;
import com.ua.foxminded.domain.University;
import com.ua.foxminded.utils.Schedule;
import com.ua.foxminded.utils.UniversityUtils;

public class Main {

	public static void main(String[] args) {
		UniversityUtils utils = new UniversityUtils();
		University university = new University(utils.generateTeachers(), utils.generateGroups(101, 111),
				utils.generateAuditories(1, 11));
		university.setSubjects(university.getTeachers().stream().map(t -> t.getSubject()).collect(toList()));
		utils.generateStudents().forEach(s -> utils.assignToGroup(s, university.getGroups()));
		Schedule schedule = new Schedule();
		List<Lesson> lessons = schedule.getSchedule(
				utils.getAcademicDays(LocalDate.of(2019, 9, 01), LocalDate.of(2019, 12, 30)), schedule.getDaySchedule(),
				university.getAuditories());
		lessons = schedule.setTeachers(lessons, university.getTeachers(), university.getAuditories());
		lessons = schedule.setGroups(lessons, university.getGroups(), university.getAuditories());
		university.setLessons(lessons);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Menu menu = new Menu();
		Scanner scanner = new Scanner(System.in);
		int number = 0;
		try {
			while (true) {
				System.out.println(Menu.MENU);
				number = scanner.nextInt();
				if (number == 8) {
					break;
				}
				System.out.println(menu.showMenu(number));
				System.out.println(menu.executeCommand(number, reader.readLine(), university));
			}
			scanner.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}