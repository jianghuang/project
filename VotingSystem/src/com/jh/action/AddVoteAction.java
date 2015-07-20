package com.jh.action;

import com.jh.bean.Vote;
import com.jh.bean.VoteOption;
import com.jh.dao.VoteDAO;
import com.jh.dao.VoteOptionDAO;
import com.jh.daoFactory.VoteDAOFactory;
import com.jh.daoFactory.VoteOptionDAOFactory;
import com.opensymphony.xwork2.ActionSupport;

public class AddVoteAction extends ActionSupport {
	private int channelID;
	private String voteName;
	private String[] voteOption;
	public int getChannelID() {
		return channelID;
	}
	public void setChannelID(int channelID) {
		this.channelID = channelID;
	}
	public String getVoteName() {
		return voteName;
	}
	public void setVoteName(String voteName) {
		this.voteName = voteName;
	}
	public String[] getVoteOption() {
		return voteOption;
	}
	public void setVoteOption(String[] voteOption) {
		this.voteOption = voteOption;
	}
	public String exceute() throws Exception {
		VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
		VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstance();
		Vote vote = new Vote();
		vote.setChannelID(channelID);
		vote.setVoteName(voteName);
		voteDAO.addVote(vote);
		int voteID = voteDAO.findVoteByName(voteName).getVoteID();
		for(String voteOptionName : voteOption) {
			VoteOption vp = new VoteOption();
			vp.setVoteID(voteID);
			vp.setVoteOptionName(voteOptionName);
			voteOptionDAO.addVoteOption(vp);
		}
		return this.SUCCESS;
	}
}
