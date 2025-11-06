package com.mings.dao;

import com.mings.domain.Teacher;

/**
 * @program: infoManager
 * @description: 教师dao
 * @author: mings
 * @create: 2025-11-05 21:32
 **/
public class TeacherDao {
	private static Teacher[] teachers = new Teacher[5];

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
