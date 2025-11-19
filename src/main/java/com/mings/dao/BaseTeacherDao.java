package com.mings.dao;

import com.mings.domain.Teacher;

/**
 * @program: infoManager
 * @description: 教师dao
 * @author: mings
 * @create: 2025-11-05 21:32
 **/
public interface BaseTeacherDao {


	public abstract Boolean isExist(String id);

	public abstract boolean addTeacher(Teacher teacher);

	public abstract Teacher[] findAllTeacher();

	public abstract void deleteTeacherById(String delId);


	public abstract boolean updateTeacher(String updateId, Teacher teacher);
}
