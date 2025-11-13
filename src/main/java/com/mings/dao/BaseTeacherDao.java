package com.mings.dao;

import com.mings.domain.Teacher;

import java.util.ArrayList;

/**
 * @program: infoManager
 * @description: 教师dao
 * @author: mings
 * @create: 2025-11-05 21:32
 **/
public abstract class BaseTeacherDao {
	private static ArrayList<Teacher> teachers = new ArrayList<>();

	static {
		teachers.add(new Teacher("heima001", "小王", 30, "1990-01-01"));
		teachers.add(new Teacher("heima002", "小张", 31, "1991-01-01"));
		teachers.add(new Teacher("heima003", "小李", 32, "1992-01-01"));
		teachers.add(new Teacher("heima004", "小赵", 33, "1993-01-01"));
		teachers.add(new Teacher("heima005", "小周", 34, "1994-01-01"));
	}

	public abstract Boolean isExist(String id);

	public abstract boolean addTeacher(Teacher teacher);

	public abstract Teacher[] findAllTeacher();

	public abstract void deleteTeacherById(String delId);


	public abstract boolean updateTeacher(String updateId, Teacher teacher);
}
