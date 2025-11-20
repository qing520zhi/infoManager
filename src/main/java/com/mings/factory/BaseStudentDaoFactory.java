package com.mings.factory;

import com.mings.dao.BaseStudentDao;
import com.mings.dao.OtherStudentDao;

/**
 * @program: infoManager
 * @description: 工厂类
 * @author: mings
 * @create: 2025-11-20 10:48
 **/
public class BaseStudentDaoFactory {
	public static BaseStudentDao getStudentDao() {
		return new OtherStudentDao();
	}
}
