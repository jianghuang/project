package com.jh.bean;

/**  
 * 类名称： Channel
 * 类描述： 封装了投票频道的所有信息
*/ 

public class Channel {
	private int channelID;
	private String channelName;
	public int getChannelID() {
		return channelID;
	}
	public void setChannelID(int channelID) {
		this.channelID = channelID;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
}
