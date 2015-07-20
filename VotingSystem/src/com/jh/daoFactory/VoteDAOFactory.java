package com.jh.daoFactory;

import com.jh.dao.VoteDAO;
import com.jh.daoImpl.VoteDAOImpl;

public class VoteDAOFactory {
	public static VoteDAO getVoteDAOInstance() {
		return new VoteDAOImpl();
	}
}
