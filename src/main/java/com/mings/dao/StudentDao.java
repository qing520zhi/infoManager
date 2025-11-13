package com.mings.dao;

import com.mings.domain.Student;

/**
 * @program: infoManager
 * @description: 学生类dao 仓管
 * @author: mings
 * @create: 2025-11-05 10:11
 **/
public class StudentDao extends BaseStudentDao {

	private static Student[] stus = new Student[5];

	static {
		stus[0] = new Student("heima001", "小王", 18, "2000-01-01");
		stus[1] = new Student("heima002", "小张", 19, "2001-01-01");
		stus[2] = new Student("heima003", "小李", 20, "2002-01-01");
		stus[3] = new Student("heima004", "小赵", 21, "2003-01-01");
		stus[4] = new Student("heima005", "小周", 22, "2004-01-01");
	}

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
