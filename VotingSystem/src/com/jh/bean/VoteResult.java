package com.jh.bean;

import java.util.List;

/**  
 * �����ƣ� VoteResult
 * �������� ��װ��ͶƱ��Ϣ��ͶƱѡ����Ϣ
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
