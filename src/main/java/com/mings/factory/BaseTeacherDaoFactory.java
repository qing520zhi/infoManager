package com.mings.factory;

import com.mings.dao.BaseTeacherDao;
import com.mings.dao.OtherTeacherDao;

/**
 * @program: infoManager
 * @description: 工厂类
 * @author: mings
 * @create: 2025-11-20 10:53
 **/
public class BaseTeacherDaoFactory {
	public static BaseTeacherDao getTeacherDao() {
		return new OtherTeacherDao();
	}
}
