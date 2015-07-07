package com.jh.factory;

import com.jh.dao.CriticismDAO;
import com.jh.daoImpl.CriticismDAOImpl;

/**  
 * �����ƣ� CriticismDAOFactory
 * �������� ����CriticismDAOImplʵ��
*/

public class CriticismDAOFactory {
	/**  
	 * �������� getCriticismDAOInstance()
	 * �������ܣ���������������DAOʵ����ʵ�� 
	*/ 
	public static CriticismDAO getCriticismDAOInstance() {
		return new CriticismDAOImpl();
	}
}
