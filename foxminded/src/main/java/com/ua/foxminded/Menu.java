package com.ua.foxminded;

import static java.lang.System.lineSeparator;

public class Menu {

	public static final String MENU = "Enter command:" + lineSeparator() + "1 Get subjects" + lineSeparator()
			+ "2 Get groups" + lineSeparator() + "3 Get group schedule" + lineSeparator() + "4 Get teachers"
			+ lineSeparator() + "5 Get teachers schedule" + lineSeparator() + "6 Exit";

	public String showMenu(int number) {
		switch (number) {
		case 1:
			return "";
		case 2:
			return "";
		case 3:
			return "Enter group ID:";
		case 4:
			return "";
		case 5:
			return "Enter teacher name:";
		default:
			return "Wrong command";
		}
	}

//	public String executeCommand(int number, String line) {
//		switch (number) {
//		case 1:
//			return groupDao.getGroupsByStudentsCount(Integer.parseInt(line)).toString();
//		case 2:
//			return studentDao.getStudentsFromCourse(line).toString();
//		case 3:
//			Student student = new Student(line.substring(0, line.indexOf(" ")), line.substring(line.indexOf(" ") + 1));
//			studentDao.create(student);
//			return "New student added with id:" + student.getId();
//		case 4:
//			studentDao.deleteStudent(Integer.parseInt(line));
//			return "Student deleted";
//		case 5:
//			courseDao.addStudent(parseStudentId(line), parseCourseId(line));
//			return "Student added";
//		case 6:
//			studentDao.deleteStudentFromCourse(parseStudentId(line), parseCourseId(line));
//			return "Student deleted";
//		}
//		return "Wrong command";
//	}

	private int parseStudentId(String line) {
		return Integer.parseInt(line.substring(0, line.indexOf(" ")));
	}

	private int parseCourseId(String line) {
		return Integer.parseInt(line.substring(line.indexOf(" ") + 1));
	}
}