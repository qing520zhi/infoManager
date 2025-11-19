package com.mings.dao;

import com.mings.domain.Teacher;

import java.util.ArrayList;

/**
 * @program: infoManager
 * @description: 教师dao
 * @author: mings
 * @create: 2025-11-05 21:32
 **/
public class OtherTeacherDao implements BaseTeacherDao {
	private static ArrayList<Teacher> teachers = new ArrayList<>();

	static {
		teachers.add(new Teacher("heima001", "小王", 30, "1990-01-01"));
		teachers.add(new Teacher("heima002", "小张", 31, "1991-01-01"));
		teachers.add(new Teacher("heima003", "小李", 32, "1992-01-01"));
		teachers.add(new Teacher("heima004", "小赵", 33, "1993-01-01"));
		teachers.add(new Teacher("heima005", "小周", 34, "1994-01-01"));
	}

	public Boolean isExist(String id) {
		for (int i = 0; i < teachers.size(); i++) {
			if (teachers.get(i) != null && teachers.get(i).getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	public boolean addTeacher(Teacher teacher) {
		teachers.add(teacher);
		return true;
	}

	public Teacher[] findAllTeacher() {
		Teacher[] teacher = new Teacher[teachers.size()];
		for (int i = 0; i < teachers.size(); i++) {
			teacher[i] = teachers.get(i);
		}
		return teacher;
	}

	public void deleteTeacherById(String delId) {
		int index1 = getIndex(delId);
		teachers.remove(index1);
	}

	public int getIndex(String id) {
		int index = -1;
		for (int i = 0; i < teachers.size(); i++) {
			Teacher tea = teachers.get(i);
			if (tea != null && tea.getId().equals(id)) {
				index = i;
				break;
			}
		}
		return index;
	}

	public boolean updateTeacher(String updateId, Teacher teacher) {
		int index = getIndex(updateId);
		teachers.set(index, teacher);
		return true;
	}
}
