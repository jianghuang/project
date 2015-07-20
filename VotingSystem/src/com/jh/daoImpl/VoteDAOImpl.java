package com.jh.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jh.bean.Vote;
import com.jh.dao.VoteDAO;
import com.jh.util.DBConnection;
import com.jh.util.Page;

public class VoteDAOImpl implements VoteDAO {
	private static final String ADDSQL = "INSERT INTO TB_VOTE(VOTENAME,CHANNELID) VALUES(?, ?)";
	private static final String QUERYSQL = "SELECT * FROM TB_VOTE WHERE VOTENAME = ?";
	private static final String FINDSQL = "SELECT COUNT(*) FROM TB_VOTE";
	private static final String FINDBYIDSQL = "SELECT * FROM TB_VOTE LIMIT ?,?";
	Connection conn = null;				
	PreparedStatement pstmt = null;	
	ResultSet rs = null;
	Vote vote = null;

	@Override
	public void addVote(Vote vote) {
		conn = DBConnection.getConnection();
		try {
			pstmt = conn.prepareStatement(ADDSQL);
			pstmt.setString(1, vote.getVoteName());
			pstmt.setInt(2, vote.getChannelID());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
	}

	@Override
	public void updateVote(Vote vote) {
		
	}

	@Override
	public void deleteVote(int voteID) {
		
	}

	@Override
	public List<Vote> findAllVote(Page page) {
		List<Vote> votes = new ArrayList<Vote>();
		conn = DBConnection.getConnection();
		try {
			pstmt = conn.prepareStatement(FINDBYIDSQL);
			pstmt.setInt(1, page.getBeginIndex());
			pstmt.setInt(2, page.getEveryPage());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Vote vote = new Vote();
				vote.setVoteID(rs.getInt(1));
				vote.setVoteName(rs.getString(2));
				vote.setChannelID(rs.getInt(3));
				votes.add(vote);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return votes;
	}

	@Override
	public List<Vote> findVoteByChannel(Page page, int channelID) {
		return null;
	}

	@Override
	public Vote findVoteById(int voteID) {
		return null;
	}

	@Override
	public Vote findVoteByName(String voteName) {
		conn = DBConnection.getConnection();
		try {
			pstmt = conn.prepareStatement(QUERYSQL);
			pstmt.setString(1, voteName);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vote = new Vote();
				vote.setVoteID(rs.getInt(1));
				vote.setVoteName(rs.getString(2));
				vote.setChannelID(rs.getInt(3));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return vote;
	}

	@Override
	public int findAllCount() {
		int count = 0;
		conn = DBConnection.getConnection();
		try {
			pstmt = conn.prepareStatement(FINDSQL);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return count;
	}

	@Override
	public int fintCountByChannel(int channelID) {
		return 0;
	}

}
