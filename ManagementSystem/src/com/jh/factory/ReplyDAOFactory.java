package com.jh.factory;

import com.jh.dao.ReplyDAO;
import com.jh.daoImpl.ReplyDAOImpl;

/**  
 * 类名称： ReplyDAOFactory
 * 类描述： 创建ReplyDAOImpl实例
*/ 

public class ReplyDAOFactory {
	/**  
	 * 函数名： getMessageDAOInstance()
	 * 函数功能：工厂方法，返回DAO实现类实例 
	*/ 
	public static ReplyDAO getReplyDAOInstance() {
		return new ReplyDAOImpl();
	}
}
