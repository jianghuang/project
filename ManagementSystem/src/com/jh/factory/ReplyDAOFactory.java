package com.jh.factory;

import com.jh.dao.ReplyDAO;
import com.jh.daoImpl.ReplyDAOImpl;

/**  
 * �����ƣ� ReplyDAOFactory
 * �������� ����ReplyDAOImplʵ��
*/ 

public class ReplyDAOFactory {
	/**  
	 * �������� getMessageDAOInstance()
	 * �������ܣ���������������DAOʵ����ʵ�� 
	*/ 
	public static ReplyDAO getReplyDAOInstance() {
		return new ReplyDAOImpl();
	}
}
