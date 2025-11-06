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
public class StudentController {

	Scanner scanner = new Scanner(System.in);
	private StudentService studentService = new StudentService();

	private static Student setStudent(String id, String name, int age, String birthday) {
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setAge(age);
		student.setBirthday(birthday);
		return student;
	}

	public void start() {

		studentLoop:
		while (true) {
			System.out.println("--------欢迎来到 <学生> 管理系统--------");
			System.out.println("请输入您的选择: 1.添加学生  2.删除学生  3.修改学生  4.查看学生  5.退出");
			int choice = scanner.nextInt();
			switch (choice) {
				case 1:
					//System.out.println("添加学生");
					addStudent();
					break;
				case 2:
					//System.out.println("删除学生");
					deleteStudentById();
					break;
				case 3:
					//System.out.println("修改学生");
					updateStudent();
					break;
				case 4:
					//System.out.println("查看学生");
					findAllStudent();
					break;
				case 5:
					System.out.println("感谢您使用<学生> 管理系统，再见！");
					break studentLoop;
				default:
					System.out.println("您的输入有误，请重新输入");
			}
		}
	}

	private void updateStudent() {
		Student[] students = studentService.findAllStudent();
		if (students == null) {
			System.out.println("没有学生信息，请先添加学生");
			return;
		}
		String updateid;
		while (true) {
			System.out.println("请输入修改学生的id:");
			updateid = scanner.next();
			Boolean exist = studentService.isExist(updateid);
			if (exist) {
				System.out.println("请输入学生姓名:");
				String name = scanner.next();
				int age = getAge();
				System.out.println("请输入学生生日:");
				String birthday = scanner.next();
				//Student stu = new Student(updateid, name, age, birthday);
				Student stu = setStudent(updateid, name, age, birthday);
				studentService.updateStudent(updateid, stu);
				System.out.println("修改成功");
				break;
			} else {
				System.out.println("该学生id不存在，请重新输入");
			}
		}
	}

	private int getAge() {
		int age;
		while (true) {
			System.out.println("请输入学生年龄:");
			age = scanner.nextInt();
			if (age >= 0 && age <= 120) {
				break;
			} else {
				System.out.println("您的输入有误，请重新输入");
			}
		}
		return age;
	}

	private void deleteStudentById() {
		//1、调用service方法，获取所有学生信息
		Student[] students = studentService.findAllStudent();
		//2、判断数组是否为空
		if (students == null) {
			System.out.println("没有学生信息，请先添加学生");
			return;
		}
		String delid;
		while (true) {
			System.out.println("请输入要删除的学生id:");
			delid = scanner.next();
			Boolean exist = studentService.isExist(delid);
			if (exist) {
				studentService.deleteStudentById(delid);
				System.out.println("删除成功");
				break;
			} else {
				System.out.println("该学生id不存在，请重新输入");
			}
		}
	}

	private void findAllStudent() {

		//1、调用service方法，获取所有学生信息
		Student[] students = studentService.findAllStudent();
		//2、判断数组是否为空
		if (students == null) {
			System.out.println("没有学生信息，请先添加学生");
			return;
		}
		//3、遍历数组，打印所有学生信息
		System.out.println("学号\t姓名\t年龄\t生日");
		for (int i = 0; i < students.length; i++) {
			Student stu = students[i];
			if (stu != null) {
				System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t\t" + stu.getBirthday());
			}
		}
	}

	private void addStudent() {
		//定义id变量，用于接收用户输入的学生id
		String id;
		while (true) {
			System.out.println("请输入学生id:");
			id = scanner.next();
			Boolean isExist = studentService.isExist(id);
			if (isExist) {
				System.out.println("该学生id已存在，请重新输入");
			} else {
				break;
			}
		}
		System.out.println("请输入学生姓名:");
		String name = scanner.next();
		int age = getAge();
		System.out.println("请输入学生生日:");
		String birthday = scanner.next();
		Student student = setStudent(id, name, age, birthday);
		boolean addResult = studentService.addStudent(student);
		if (addResult) {
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败");
		}
	}
}
