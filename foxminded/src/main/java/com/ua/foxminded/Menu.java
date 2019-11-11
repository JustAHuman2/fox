package com.ua.foxminded;

import static java.lang.System.lineSeparator;
import java.time.LocalDate;
import java.util.List;
import com.ua.foxminded.domain.Group;
import com.ua.foxminded.domain.Subject;
import com.ua.foxminded.domain.Teacher;
import com.ua.foxminded.domain.University;

public class Menu {

	public static final String MENU = "Enter command:" + lineSeparator() + "1 Get subjects" + lineSeparator()
			+ "2 Get groups" + lineSeparator() + "3 Get teachers" + lineSeparator() + "4 Get group schedule"
			+ lineSeparator() + "5 Get teachers schedule" + lineSeparator() + "6 Exit";

	public String showMenu(int number, List<Teacher> teachers, List<Subject> subjects, List<Group> groups) {
		switch (number) {
		case 1:
			return subjects.toString();
		case 2:
			return groups.toString();
		case 3:
			return teachers.toString();
		case 4:
			return "Enter group ID:";
		case 5:
			return "Enter teacher name:";
		default:
			return "Wrong command";
		}
	}

	public String executeCommand(int number, String line, List<Teacher> teachers, List<Subject> subjects,
			List<Group> groups) {
		University university = new University(teachers, subjects, groups);
		switch (number) {
		case 4:
			return university
					.getGroupSchedule(parseGroup(line, groups), LocalDate.of(2019, 9, 01), LocalDate.of(2019, 12, 30))
					.toString();
		case 5:
			return university.getTeacherSchedule(parseTeacher(line, teachers), LocalDate.of(2019, 9, 01),
					LocalDate.of(2019, 12, 30)).toString();
		default:
			return "Wrong command";
		}
	}

	private Group parseGroup(String line, List<Group> groups) {
		return groups.stream().filter(g -> g.getId() == Integer.parseInt(line)).findAny().get();
	}

	private Teacher parseTeacher(String line, List<Teacher> teachers) {
		return teachers.stream().filter(t -> t.getName().equals(line)).findAny().get();
	}
}