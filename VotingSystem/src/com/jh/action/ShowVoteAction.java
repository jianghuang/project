package com.jh.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.jh.bean.Vote;
import com.jh.bean.VoteOption;
import com.jh.bean.VoteResult;
import com.jh.dao.VoteDAO;
import com.jh.dao.VoteOptionDAO;
import com.jh.daoFactory.VoteDAOFactory;
import com.jh.daoFactory.VoteOptionDAOFactory;
import com.jh.util.Page;
import com.jh.util.PageUtil;
import com.opensymphony.xwork2.ActionSupport;

public class ShowVoteAction extends ActionSupport {
	private int currentPage;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public String execute() throws Exception {
		VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
		VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstance();
		int totalCount = voteDAO.findAllCount();
		Page page = PageUtil.createPage(10, totalCount, currentPage);
		List<Vote> votes = voteDAO.findAllVote(page);
		List<VoteResult> voteResultList = new ArrayList<VoteResult>();
		for(Vote vote : votes) {
			List<VoteOption> voteOption = voteOptionDAO.findVoteOptionByVoteID(vote.getVoteID());
			VoteResult voteResult = new VoteResult();
			voteResult.setVote(vote);
			voteResult.setVoteOption(voteOption);
			voteResultList.add(voteResult);
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("voteResultList", voteResultList);
		request.setAttribute("page", page);
		return this.SUCCESS;
	}
}
