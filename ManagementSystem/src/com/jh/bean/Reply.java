package com.jh.bean;

import java.util.Date;

/**  
 * 类名称： Reply
 * 类描述： 封装了回复的所有信息
*/ 

public class Reply {
	private int replyID;				//回复ID
	private String replyContent;		//回复内容
	private int employeeID;				//回复人ID
	private Date replyTime;				//回复时间
	private int messageID;				//消息ID
	
	public int getReplyID() {
		return replyID;
	}
	public void setReplyID(int replyID) {
		this.replyID = replyID;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public Date getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	public int getMessageID() {
		return messageID;
	}
	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
}
