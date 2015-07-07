package com.jh.factory;

import com.jh.dao.CriticismDAO;
import com.jh.daoImpl.CriticismDAOImpl;

/**  
 * 类名称： CriticismDAOFactory
 * 类描述： 创建CriticismDAOImpl实例
*/

public class CriticismDAOFactory {
	/**  
	 * 函数名： getCriticismDAOInstance()
	 * 函数功能：工厂方法，返回DAO实现类实例 
	*/ 
	public static CriticismDAO getCriticismDAOInstance() {
		return new CriticismDAOImpl();
	}
}
