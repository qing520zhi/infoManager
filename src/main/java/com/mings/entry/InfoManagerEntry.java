package com.mings.entry;

import com.mings.controller.OtherStudentController;
import com.mings.controller.TeacherController;

import java.util.Scanner;

/**
 * @program: infoManager
 * @description: 项目启动类
 * @author: mings
 * @create: 2025-11-05 10:13
 **/
public class InfoManagerEntry {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("--------欢迎来到信息管理系统--------");
			System.out.println("请输入您的选择: 1.学生管理  2.老师管理  3.退出");
			int choice = scanner.nextInt();
			switch (choice) {
				case 1:
					//System.out.println("进入学生管理系统");
					OtherStudentController studentController = new OtherStudentController();
					studentController.start();
					break;
				case 2:
					//System.out.println("进入老师管理系统");
					TeacherController teacherController = new TeacherController();
					teacherController.start();
					break;
				case 3:
					System.out.println("感谢您的使用，再见！");
					//break;
					//退出程序
					System.exit(0);
				default:
					System.out.println("您的输入有误，请重新输入");
					break;
			}
		}
	}
}
