package com.ua.foxminded;

import static java.lang.System.lineSeparator;
import java.time.LocalDate;
import java.util.List;
import com.ua.foxminded.domain.Group;
import com.ua.foxminded.domain.Teacher;
import com.ua.foxminded.domain.University;

public class Menu {

	public static final String MENU = "Enter command:" + lineSeparator() + "1 Get list" + lineSeparator()
			+ "2 Get group schedule" + lineSeparator() + "3 Get teachers schedule" + lineSeparator() + "4 Exit";

	public String showMenu(int number) {
		switch (number) {
		case 1:
			return "1 Subjects" + lineSeparator() + "2 Teachers" + lineSeparator() + "3 Groups";
		case 2:
			return "Enter group ID:";
		case 3:
			return "Enter teacher name:";
		default:
			return "Wrong command";
		}
	}

	public String executeCommand(int number, String line, University university) {
		switch (number) {
		case 1:
			switch (line) {
			case "1":
				return university.getSubjects().toString();
			case "2":
				return university.getTeachers().toString();
			case "3":
				return university.getGroups().toString();
			}
		case 2:
			Group group = parseGroup(line, university.getGroups());
			return group == null ? "Group not found"
					: university.getGroupSchedule(parseGroup(line, university.getGroups()), LocalDate.of(2019, 9, 01),
							LocalDate.of(2019, 12, 30)).toString();
		case 3:
			Teacher teacher = parseTeacher(line, university.getTeachers());
			return teacher == null ? "Teacher not found"
					: university.getTeacherSchedule(teacher, LocalDate.of(2019, 9, 01), LocalDate.of(2019, 12, 30))
							.toString();
		default:
			return "Wrong command";
		}
	}

	private Group parseGroup(String line, List<Group> groups) {
		return groups.stream().filter(g -> g.getId() == Integer.parseInt(line)).findAny().orElse(null);
	}

	private Teacher parseTeacher(String line, List<Teacher> teachers) {
		return teachers.stream().filter(t -> t.getName().equals(line)).findAny().orElse(null);
	}
}