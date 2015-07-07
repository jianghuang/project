package com.jh.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.jh.bean.Criticism;
import com.jh.dao.CriticismDAO;
import com.jh.util.DBConnection;

/**  
 * �����ƣ� CriticismDAOImpl
 * �������� ʵ��CriticismDAO�ӿ��з���
*/ 

public class CriticismDAOImpl implements CriticismDAO {
	private static final String ADDSQL = "INSERT INTO TB_CRITICISM(CRITICISMCONTENT, EMPLOYEEID, CRITICISMTIME, MESSAGEID) VALUES(?, ?, ?, ?)";
	private static final String FINDSQL = "SELECT * FROM TB_CRITICISM WHERE MESSAGEID = ?";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**  
	 * �������� addCriticism(Criticism criticism)
	 * �������ܣ��������
	*/ 
	public void addCriticism(Criticism criticism) {
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(ADDSQL);
			pstmt.setString(1, criticism.getCriticismContent());
			pstmt.setInt(2, criticism.getEmployeeID());
			pstmt.setTimestamp(3, new Timestamp(criticism.getCriticismTime().getTime()));
			pstmt.setInt(4, criticism.getMessageID());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
	}

	/**  
	 * �������� findCriticismByMsgID(int messageID)
	 * �������ܣ�������ID��������
	*/ 
	public Criticism findCriticismByMsgID(int messageID) {
		Criticism criticism = new Criticism();
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(FINDSQL);
			pstmt.setInt(1, messageID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				criticism.setCriticismID(rs.getInt(1));
				criticism.setCriticismContent(rs.getString(2));
				criticism.setEmployeeID(rs.getInt(3));
				criticism.setCriticismTime(rs.getTimestamp(4));
				criticism.setMessageID(rs.getInt(4));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return criticism;
	}

}
