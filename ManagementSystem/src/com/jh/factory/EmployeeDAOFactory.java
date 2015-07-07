package com.jh.factory;

import com.jh.dao.EmployeeDAO;
import com.jh.daoImpl.EmployeeDAOImpl;

/**  
 * 类名称： EmployeeDAOFactory
 * 类描述： 创建EmployeeDAOImpl实例
*/ 

public class EmployeeDAOFactory {
	/**  
	 * 函数名： getEmployeeDAOInstance()
	 * 函数功能：工厂方法，返回DAO实现类实例 
	*/ 
	public static EmployeeDAO getEmployeeDAOInstance() {
		return new EmployeeDAOImpl();
	}
}
