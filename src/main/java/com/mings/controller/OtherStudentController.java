package com.mings.controller;

import com.mings.domain.Student;
import com.mings.service.StudentService;

import java.util.Scanner;

/**
 * @program: infoManager
 * @description: 学生controller类 客服接待
 * @author: mings
 * @create: 2025-11-05 10:10
 **/
public class OtherStudentController extends BaseStudentController {

	Scanner scanner = new Scanner(System.in);
	private StudentService studentService = new StudentService();

	@Override
	public Student setStudent(String id, String name, int age, String birthday) {
		Student student = new Student(id, name, age, birthday);

		/*student.setId(id);
		student.setName(name);
		student.setAge(age);
		student.setBirthday(birthday);*/
		return student;
	}
}
