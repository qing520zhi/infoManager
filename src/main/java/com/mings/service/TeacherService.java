package com.mings.service;

import com.mings.dao.BaseTeacherDao;
import com.mings.domain.Teacher;
import com.mings.factory.BaseTeacherDaoFactory;

/**
 * @program: infoManager
 * @description: 教师service
 * @author: mings
 * @create: 2025-11-05 21:32
 **/
public class TeacherService {

	//通过构造方法获取教师dao
	//private OtherTeacherDao teacherDao = new OtherTeacherDao();
	//通过工厂类获取教师dao
	private BaseTeacherDao teacherDao = BaseTeacherDaoFactory.getTeacherDao();


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
