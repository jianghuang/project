package com.jh.dao;

import java.util.List;

import com.jh.bean.Reply;
import com.jh.util.Page;

/**  
 * �ӿ����ƣ� ReplyDAO
 * �ӿ������� �����ظ���Ϣ���в���
*/ 

public interface ReplyDAO {
	public void addReply(Reply reply);
	public List<Reply> findReplayByMsgID(int messageID, Page page);
	public int findCountByMsgID(int messageID);
}
