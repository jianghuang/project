package com.jh.factory;

import com.jh.dao.MessageDAO;
import com.jh.daoImpl.MessageDAOImpl;

/**  
 * 类名称： MessageDAOFactory
 * 类描述： 创建MessageDAOImpl实例
*/ 

public class MessageDAOFactory {
	/**  
	 * 函数名： getMessageDAOInstance()
	 * 函数功能：工厂方法，返回DAO实现类实例 
	*/ 
	public static MessageDAO getMessageDAOInstance() {
		return new MessageDAOImpl();
	}
}
