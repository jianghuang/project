package com.jh.dao;

import java.util.List;

import com.jh.bean.Message;
import com.jh.util.Page;

/**  
 * 接口名称： MessageDAO
 * 接口描述： 声明消息信息所有操作
*/ 

public interface MessageDAO {
	public void addMessage(Message message);				//定义添加消息方法
	public void updateMessage(Message message);				//定义修改消息方法
	public void deleteMessage(int messageID);				//定义删除消息方法
	public List<Message> findAllMessage(Page page);			//定义按页查询消息方法
	public Message findMessageById(int messageID);			//定义按ID查询消息方法
	public int findAllCount();								//定义查询消息记录数
}
