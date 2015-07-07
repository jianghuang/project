package com.jh.dao;

import java.util.List;

import com.jh.bean.Message;
import com.jh.util.Page;

/**  
 * �ӿ����ƣ� MessageDAO
 * �ӿ������� ������Ϣ��Ϣ���в���
*/ 

public interface MessageDAO {
	public void addMessage(Message message);				//���������Ϣ����
	public void updateMessage(Message message);				//�����޸���Ϣ����
	public void deleteMessage(int messageID);				//����ɾ����Ϣ����
	public List<Message> findAllMessage(Page page);			//���尴ҳ��ѯ��Ϣ����
	public Message findMessageById(int messageID);			//���尴ID��ѯ��Ϣ����
	public int findAllCount();								//�����ѯ��Ϣ��¼��
}
