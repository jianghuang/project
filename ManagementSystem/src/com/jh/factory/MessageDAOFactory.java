package com.jh.factory;

import com.jh.dao.MessageDAO;
import com.jh.daoImpl.MessageDAOImpl;

/**  
 * �����ƣ� MessageDAOFactory
 * �������� ����MessageDAOImplʵ��
*/ 

public class MessageDAOFactory {
	/**  
	 * �������� getMessageDAOInstance()
	 * �������ܣ���������������DAOʵ����ʵ�� 
	*/ 
	public static MessageDAO getMessageDAOInstance() {
		return new MessageDAOImpl();
	}
}
