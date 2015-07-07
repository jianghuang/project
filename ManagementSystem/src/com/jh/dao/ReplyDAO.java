package com.jh.dao;

import java.util.List;

import com.jh.bean.Reply;
import com.jh.util.Page;

/**  
 * 接口名称： ReplyDAO
 * 接口描述： 声明回复信息所有操作
*/ 

public interface ReplyDAO {
	public void addReply(Reply reply);
	public List<Reply> findReplayByMsgID(int messageID, Page page);
	public int findCountByMsgID(int messageID);
}
