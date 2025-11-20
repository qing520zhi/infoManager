package com.mings.service;

import com.mings.dao.BaseStudentDao;
import com.mings.domain.Student;
import com.mings.factory.BaseStudentDaoFactory;

/**
 * @program: infoManager
 * @description: 学生类service 业务员
 * @author: mings
 * @create: 2025-11-05 10:12
 **/
public class StudentService {

	//private OtherStudentDao studentDao = new OtherStudentDao();
	//通过工厂类获取dao对象
	private BaseStudentDao studentDao = BaseStudentDaoFactory.getStudentDao();

	public boolean addStudent(Student student) {
		return studentDao.addStudent(student);
	}

	public Boolean isExist(String id) {
		// 1、调用dao方法，获取所有学生信息
		Student[] stus = studentDao.findAllStudent();
		boolean flag = false;
		//2、遍历数组，判断id是否相等
		for (int i = 0; i < stus.length; i++) {
			Student stu = stus[i];
			// 先判断数组元素是否为空，再判断id是否为空，最后判断id是否相等
			if (stu != null && stu.getId() != null && stu.getId().equals(id)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public Student[] findAllStudent() {
		// 1、调用dao方法，获取所有学生信息
		Student[] stus = studentDao.findAllStudent();
		// 2、判断数组是否为空
		boolean flag = false;
		for (int i = 0; i < stus.length; i++) {
			// 判断数组元素是否为空
			if (stus[i] != null) {
				flag = true;
				break;
			}
		}
		if (flag) {
			// 有数据
			return stus;
		} else {
			// 无数据
			return null;
		}
	}

	public void deleteStudentById(String delid) {
		studentDao.deleteStudentById(delid);
	}

	public void updateStudent(String updateid, Student stu) {
		studentDao.updateStudent(updateid, stu);
	}
}
