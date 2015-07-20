package com.jh.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jh.bean.VoteOption;
import com.jh.dao.VoteOptionDAO;
import com.jh.util.DBConnection;

public class VoteOptionDAOImpl implements VoteOptionDAO {
	private static final String ADDSQL = "INSERT INTO TB_VOTEOPTION(VOTEOPTIONNAME, VOTEID, TICKETNUM) VALUES(?, ?, ?)";
	private static final String FINDBYIDSQL = "SELECT * FROM TB_VOTEOPTION WHERE VOTEID = ?";
	Connection conn = null;				
	PreparedStatement pstmt = null;	
	ResultSet rs = null;
	VoteOption voteOption = null;

	@Override
	public void addVoteOption(VoteOption voteOption) {
		conn = DBConnection.getConnection();
		try {
			pstmt = conn.prepareStatement(ADDSQL);
			pstmt.setString(1, voteOption.getVoteOptionName());
			pstmt.setInt(2, voteOption.getVoteID());
			pstmt.setInt(3, voteOption.getTicketNum());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
	}

	@Override
	public void updateVoteOption(VoteOption voteOption) {

	}

	@Override
	public void deleteVoteOption(int voteOptionID) {

	}

	@Override
	public List<VoteOption> findVoteOptionByVoteID(int voteID) {
		List<VoteOption> voteOptions = new ArrayList<VoteOption>();
		conn = DBConnection.getConnection();
		try {
			pstmt = conn.prepareStatement(FINDBYIDSQL);
			pstmt.setInt(1, voteID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VoteOption voteOption = new VoteOption();
				voteOption.setVoteOptionID(rs.getInt(1));
				voteOption.setVoteID(rs.getInt(2));
				voteOption.setVoteOptionName(rs.getString(3));
				voteOption.setTicketNum(rs.getInt(4));
				voteOptions.add(voteOption);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return voteOptions;
	}

	@Override
	public VoteOption findVoteOptionById(int voteOptionID) {
		return voteOption;
	}

}
