package com.mings.dao;

import com.mings.domain.Student;

/**
 * @program: infoManager
 * @description: 学生类dao 仓管
 * @author: mings
 * @create: 2025-11-05 10:11
 **/
public interface  BaseStudentDao {


	public abstract boolean addStudent(Student student);

	public abstract Student[] findAllStudent();

	public  abstract int getIndex(String id);

	public abstract void deleteStudentById(String delid);

	public abstract void updateStudent(String updateid, Student stu);
}
