package com.mings.service;

import com.mings.dao.OtherTeacherDao;
import com.mings.domain.Teacher;

/**
 * @program: infoManager
 * @description: 教师service
 * @author: mings
 * @create: 2025-11-05 21:32
 **/
public class TeacherService {

	private OtherTeacherDao teacherDao = new OtherTeacherDao();

	public Boolean isExist(String id) {
		return teacherDao.isExist(id);
	}

	public boolean addTeacher(Teacher teacher) {
		return teacherDao.addTeacher(teacher);
	}

	public Teacher[] findAllTeacher() {
		Teacher[] allTeacher = teacherDao.findAllTeacher();
		boolean flag = false;
		for (int i = 0; i < allTeacher.length; i++) {
			if (allTeacher[i] != null) {
				flag = true;
				break;
			}
		}
		if (flag) {
			return allTeacher;
		} else {
			return null;
		}
	}

	public void deleteTeacherById(String delId) {
		teacherDao.deleteTeacherById(delId);
	}

	public boolean updateTeacher(String updateId, Teacher teacher) {
		return teacherDao.updateTeacher(updateId, teacher);
	}
}
