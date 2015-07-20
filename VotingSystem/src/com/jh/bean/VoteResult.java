package com.jh.bean;

import java.util.List;

/**  
 * 类名称： VoteResult
 * 类描述： 封装了投票信息和投票选项信息
*/ 

public class VoteResult {
	private Vote vote;
	private List<VoteOption> voteOption;
	public Vote getVote() {
		return vote;
	}
	public void setVote(Vote vote) {
		this.vote = vote;
	}
	public List<VoteOption> getVoteOption() {
		return voteOption;
	}
	public void setVoteOption(List<VoteOption> voteOption) {
		this.voteOption = voteOption;
	}
	
}
