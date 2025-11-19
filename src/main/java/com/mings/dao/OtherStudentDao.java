package com.mings.dao;

import com.mings.domain.Student;

import java.util.ArrayList;

/**
 * @program: infoManager
 * @description: 学生类dao 仓管
 * @author: mings
 * @create: 2025-11-05 10:11
 **/
public class OtherStudentDao implements BaseStudentDao {

	private static ArrayList<Student> stus = new ArrayList<>();

	static {
		stus.add(new Student("heima001", "小王", 18, "2000-01-01"));
		stus.add(new Student("heima002", "小张", 19, "2001-01-01"));
		stus.add(new Student("heima003", "小李", 20, "2002-01-01"));
		stus.add(new Student("heima004", "小赵", 21, "2003-01-01"));
		stus.add(new Student("heima005", "小周", 22, "2004-01-01"));
	}

	int index = -1;

	@Override
	public boolean addStudent(Student student) {
		stus.add(student);
		return true;
	}

	@Override
	public Student[] findAllStudent() {
		Student[] students = new Student[stus.size()];
		for (int i = 0; i < students.length; i++) {
			students[i] = stus.get(i);
		}
		return students;
	}

	@Override
	public void deleteStudentById(String delid) {
		int index1 = getIndex(delid);
		stus.remove(index1);
	}

	public int getIndex(String id) {
		for (int i = 0; i < stus.size(); i++) {
			Student stu = stus.get(i);
			if (stu != null && stu.getId().equals(id)) {
				index = i;
				break;
			}
		}
		return index;
	}

	public void updateStudent(String updateid, Student stu) {
		int index = getIndex(updateid);
		stus.set(index, stu);
	}
}
