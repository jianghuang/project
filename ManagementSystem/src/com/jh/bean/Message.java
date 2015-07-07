package com.jh.bean;

import java.util.Date;

/**  
 * 类名称： Message
 * 类描述： 封装了消息的所有信息
*/ 

public class Message {
	private int messageID;				//消息ID
	private String messageTitle;		//消息标题
	private String messageContent;		//消息内容
	private int employeeID;				//发布人
	private Date publishTime;			//发布时间
	
	public int getMessageID() {
		return messageID;
	}
	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
	public String getMessageTitle() {
		return messageTitle;
	}
	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date timestamp) {
		this.publishTime = timestamp;
	}
}
