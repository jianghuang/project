package com.jh.daoFactory;

import com.jh.dao.VoteOptionDAO;
import com.jh.daoImpl.VoteOptionDAOImpl;

public class VoteOptionDAOFactory {
	public static VoteOptionDAO getVoteOptionDAOInstance() {
		return new VoteOptionDAOImpl();
	}
}
