package com.mings.dao;

import com.mings.domain.Teacher;

/**
 * @program: infoManager
 * @description: 教师dao
 * @author: mings
 * @create: 2025-11-05 21:32
 **/
public class TeacherDao implements BaseTeacherDao {
	private static Teacher[] teachers = new Teacher[5];

	static {
		teachers[0] = new Teacher("heima001", "小王", 30, "1990-01-01");
		teachers[1] = new Teacher("heima002", "小张", 31, "1991-01-01");
		teachers[2] = new Teacher("heima003", "小李", 32, "1992-01-01");
		teachers[3] = new Teacher("heima004", "小赵", 33, "1993-01-01");
		teachers[4] = new Teacher("heima005", "小周", 34, "1994-01-01");
	}

	public Boolean isExist(String id) {
		for (int i = 0; i < teachers.length; i++) {
			if (teachers[i] != null && teachers[i].getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	public boolean addTeacher(Teacher teacher) {
		for (int i = 0; i < teachers.length; i++) {
			if (teachers[i] == null) {
				teachers[i] = teacher;
				return true;
			}
		}
		return false;
	}

	public Teacher[] findAllTeacher() {
		return teachers;
	}

	public void deleteTeacherById(String delId) {
		for (int i = 0; i < teachers.length; i++) {
			if (teachers[i] != null && teachers[i].getId().equals(delId)) {
				teachers[i] = null;
			}
		}
	}

	public boolean updateTeacher(String updateId, Teacher teacher) {
		for (int i = 0; i < teachers.length; i++) {
			if (teachers[i] != null && teachers[i].getId().equals(updateId)) {
				teachers[i] = teacher;
				return true;
			}
		}
		return false;
	}
}
