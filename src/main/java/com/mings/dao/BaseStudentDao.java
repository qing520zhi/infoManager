package com.mings.dao;

import com.mings.domain.Student;

/**
 * @program: infoManager
 * @description: 学生类dao 仓管
 * @author: mings
 * @create: 2025-11-05 10:11
 **/
public abstract class BaseStudentDao {

	private static Student[] stus = new Student[5];

	static {
		stus[0] = new Student("heima001", "小王", 18, "2000-01-01");
		stus[1] = new Student("heima002", "小张", 19, "2001-01-01");
		stus[2] = new Student("heima003", "小李", 20, "2002-01-01");
		stus[3] = new Student("heima004", "小赵", 21, "2003-01-01");
		stus[4] = new Student("heima005", "小周", 22, "2004-01-01");
	}

	int index = -1;

	public abstract boolean addStudent(Student student);

	public abstract Student[] findAllStudent();

	public abstract void deleteStudentById(String delid);

	public abstract void updateStudent(String updateid, Student stu);
}
