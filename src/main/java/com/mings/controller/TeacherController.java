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
public class TeacherController {

	Scanner scanner = new Scanner(System.in);
	private TeacherService teacherService = new TeacherService();

	private static Teacher setTeacher(String id, String name, int age, String birthday) {
		Teacher teacher = new Teacher();
		teacher.setId(id);
		teacher.setName(name);
		teacher.setAge(age);
		teacher.setBirthday(birthday);
		return teacher;
	}

	public void start() {

		//教师控制台循环
		teacherLoop:
		while (true) {
			System.out.println("--------欢迎来到 <老师> 管理系统--------");
			System.out.println("请输入您的选择: 1.添加老师  2.删除老师  3.修改老师  4.查看老师  5.退出");
			int choice = scanner.nextInt();
			switch (choice) {
				case 1:
					//System.out.println("添加老师");
					addTeacher();
					break;
				case 2:
					//System.out.println("删除老师");
					deleteTeacherById();
					break;
				case 3:
					//System.out.println("修改老师");
					updateTeacher();
					break;
				case 4:
					//System.out.println("查看老师");
					findAllTeacher();
					break;
				case 5:
					System.out.println("感谢您使用<老师> 管理系统，再见！");
					break teacherLoop;
				default:
					System.out.println("您的输入有误，请重新输入");
			}
		}
	}

	/**
	 * @Description: 修改教师信息
	 * @Param: updateId 教师id
	 * @return: void
	 * @Author: mings
	 * @Date: 2025/11/6
	 */
	private void updateTeacher() {
		//1、先获取所有老师信息，判断是否有老师信息
		if (isExist()) return;
		//2、遍历数组，判断id是否存在
		String updateId = findId();
		//3、如果存在，接收用户输入的新信息
		System.out.println("请输入教师姓名:");
		String name = scanner.next();
		int age;
		while (true) {
			System.out.println("请输入教师年龄:");
			age = scanner.nextInt();
			if (age >= 0 && age <= 120) {
				break;
			} else {
				System.out.println("年龄输入有误，请重新输入");
			}
		}
		System.out.println("请输入教师生日:");
		String birthday = scanner.next();
		//4、封装数据
		//Teacher teacher = setTeacher(updateId, name, age, birthday);
		Teacher teacher = setTeacher(updateId, name, age, birthday);
		//5、调用service方法，修改老师信息
		boolean updateResult = teacherService.updateTeacher(updateId, teacher);
		if (updateResult) {
			System.out.println("修改成功");
		} else {
			System.out.println("修改失败");
		}

	}

	private void deleteTeacherById() {
		if (isExist()) return;
		String delId = findId();
		//3、调用service方法，删除老师信息
		teacherService.deleteTeacherById(delId);
		System.out.println("删除成功");
	}

	private String findId() {
		//2、遍历数组，判断id是否存在
		String id;
		while (true) {
			System.out.println("请输入教师id:");
			id = scanner.next();
			Boolean isExist = teacherService.isExist(id);
			if (!isExist) {
				System.out.println("该教师id不存在，请重新输入");
			} else {
				break;
			}
		}
		return id;
	}

	private boolean isExist() {
		//1、先获取所有老师信息，判断是否有老师信息
		Teacher[] teachers = teacherService.findAllTeacher();
		if (teachers == null) {
			System.out.println("没有老师信息,请先添加老师");
			return true;
		}
		return false;
	}

	private void findAllTeacher() {
		Teacher[] teachers = teacherService.findAllTeacher();
		if (teachers == null) return;
		System.out.println("id\t姓名\t年龄\t生日");
		for (int i = 0; i < teachers.length; i++) {
			if (teachers[i] != null) {
				System.out.println(teachers[i].getId() + "\t" + teachers[i].getName() + "\t" + teachers[i].getAge() + "\t\t" + teachers[i].getBirthday());
			}

		}
	}

	private void addTeacher() {
		/*1、接收用户输入的教师信息
		 * 2、调用service方法，添加教师信息
		 * 3、提示用户添加成功
		 * */
		//1、接收用户输入的教师信息
		String id;
		while (true) {
			System.out.println("请输入教师id:");
			id = scanner.next();
			Boolean isExist = teacherService.isExist(id);
			if (isExist) {
				System.out.println("该教师id已存在，请重新输入");
			} else {
				break;
			}
		}
		System.out.println("请输入教师姓名:");
		String name = scanner.next();
		int age;
		while (true) {
			System.out.println("请输入教师年龄:");
			age = scanner.nextInt();
			if (age >= 0 && age <= 120) {
				break;
			} else {
				System.out.println("您输入的年龄有误，请重新输入");
			}
		}

		System.out.println("请输入教师生日:");
		String birthday = scanner.next();
		Teacher teacher = setTeacher(id, name, age, birthday);
		boolean addResult = teacherService.addTeacher(teacher);
		if (addResult) {
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败");
		}
	}
}
