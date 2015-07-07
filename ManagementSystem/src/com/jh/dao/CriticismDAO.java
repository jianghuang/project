package com.jh.dao;

import com.jh.bean.Criticism;

/**  
 * 接口名称： CriticismDAO
 * 接口描述： 声明批复信息所有操作
*/ 

public interface CriticismDAO {
	public void addCriticism(Criticism criticism);
	public Criticism findCriticismByMsgID(int messageID);
}