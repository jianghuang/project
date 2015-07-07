package com.jh.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.jh.bean.Reply;
import com.jh.dao.ReplyDAO;
import com.jh.util.DBConnection;
import com.jh.util.Page;

/**  
 * 类名称： ReplyDAOImpl
 * 类描述： 实现ReplyDAO接口中方法
*/ 

public class ReplyDAOImpl implements ReplyDAO {
	private static final String ADDSQL = "INSERT INTO TB_REPLY(REPLYCONTENT, EMPLOYEEID, REPLYTIME, MESSAGEID) VALUES(?, ?, ?, ?)";
	private static final String FINDSQL = "SELECT COUNT(*) FROM TB_REPLY WHERE MESSAGEID = ?";
	private static final String FINDLISTSQL = "SELECT * FROM TB_REPLY WHERE MESSAGEID = ? LIMIT ?, ?";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	/**  
	 * 函数名： addReply(Reply reply)
	 * 函数功能：添加回复
	*/ 
	public void addReply(Reply reply) {
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(ADDSQL);
			pstmt.setString(1, reply.getReplyContent());
			pstmt.setInt(2, reply.getEmployeeID());
			pstmt.setTimestamp(3, new Timestamp(reply.getReplyTime().getTime()));
			pstmt.setInt(4, reply.getMessageID());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
	}

	/**  
	 * 函数名： findReplayByMsgID(int messageID, Page page)
	 * 函数功能：通过信息ID查找回复消息
	*/ 
	public List<Reply> findReplayByMsgID(int messageID, Page page) {
		List<Reply> replyList = new ArrayList<Reply>();
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(FINDLISTSQL);
			pstmt.setInt(1, messageID);
			pstmt.setInt(2, page.getBeginIndex());
			pstmt.setInt(3, page.getEveryPage());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Reply reply = new Reply();
				reply.setReplyID(rs.getInt(1));
				reply.setReplyContent(rs.getString(2));
				reply.setEmployeeID(rs.getInt(3));
				reply.setReplyTime(rs.getTimestamp(4));
				reply.setMessageID(rs.getInt(5));
				replyList.add(reply);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return replyList;
	}

	/**  
	 * 函数名： findCountByMsgID(int messageID)
	 * 函数功能：查询消息回复记录数
	*/ 
	public int findCountByMsgID(int messageID) {
		int count = 0;
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(FINDSQL);
			pstmt.setInt(1, messageID);
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

}
