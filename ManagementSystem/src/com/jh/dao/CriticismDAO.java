package com.jh.dao;

import com.jh.bean.Criticism;

/**  
 * �ӿ����ƣ� CriticismDAO
 * �ӿ������� ����������Ϣ���в���
*/ 

public interface CriticismDAO {
	public void addCriticism(Criticism criticism);
	public Criticism findCriticismByMsgID(int messageID);
}