package com.jh.factory;

import com.jh.dao.EmployeeDAO;
import com.jh.daoImpl.EmployeeDAOImpl;

/**  
 * �����ƣ� EmployeeDAOFactory
 * �������� ����EmployeeDAOImplʵ��
*/ 

public class EmployeeDAOFactory {
	/**  
	 * �������� getEmployeeDAOInstance()
	 * �������ܣ���������������DAOʵ����ʵ�� 
	*/ 
	public static EmployeeDAO getEmployeeDAOInstance() {
		return new EmployeeDAOImpl();
	}
}
