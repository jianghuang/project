package com.jh.bean;

/**  
 * 类名称： Vote
 * 类描述： 封装了投票的所有信息
*/ 

public class Vote {
	private int voteID;
	private String voteName;
	private int channelID;
	public int getVoteID() {
		return voteID;
	}
	public void setVoteID(int voteID) {
		this.voteID = voteID;
	}
	public String getVoteName() {
		return voteName;
	}
	public void setVoteName(String voteName) {
		this.voteName = voteName;
	}
	public int getChannelID() {
		return channelID;
	}
	public void setChannelID(int channelID) {
		this.channelID = channelID;
	}
}
