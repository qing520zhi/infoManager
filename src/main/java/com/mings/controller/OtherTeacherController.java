package com.mings.controller;

import com.mings.domain.Teacher;
import com.mings.service.TeacherService;

import java.util.Scanner;

/**
 * @program: infoManager
 * @description: 教师controller类  接待员
 * @author: mings
 * @create: 2025-11-05 21:02
 **/
public class OtherTeacherController extends BaseTeacherController {

	Scanner scanner = new Scanner(System.in);
	private TeacherService teacherService = new TeacherService();

	public Teacher setTeacher(String id, String name, int age, String birthday) {
		Teacher teacher = new Teacher(id, name, age, birthday);
		return teacher;
	}

}
