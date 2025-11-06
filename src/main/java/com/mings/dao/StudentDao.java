package com.mings.dao;

import com.mings.domain.Student;

/**
 * @program: infoManager
 * @description: 学生类dao 仓管
 * @author: mings
 * @create: 2025-11-05 10:11
 **/
public class StudentDao {

	private static Student[] stus = new Student[5];

	int index = -1;

	public boolean addStudent(Student student) {
		for (int i = 0; i < stus.length; i++) {
			if (stus[i] == null) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			return false;
		} else {
			stus[index] = student;
			return true;
		}
	}

	public Student[] findAllStudent() {
		return stus;
	}

	public void deleteStudentById(String delid) {
		for (int i = 0; i < stus.length; i++) {
			if (stus[i] != null && stus[i].getId() != null && stus[i].getId().equals(delid)) {
				stus[i] = null;
			}
		}
	}

	public void updateStudent(String updateid, Student stu) {
		for (int i = 0; i < stus.length; i++) {
			if (stus[i] != null && stus[i].getId() != null && stus[i].getId().equals(updateid)) {
				stus[i] = stu;
			}
		}
	}
}
