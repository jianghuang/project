package com.jh.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.jh.bean.Message;
import com.jh.dao.MessageDAO;
import com.jh.util.DBConnection;
import com.jh.util.Page;

/**  
 * 类名称： MessageDAOImpl
 * 类描述： 实现MessageDAO接口中方法
*/ 

public class MessageDAOImpl implements MessageDAO {
	private static final String ADDSQL = "INSERT INTO TB_MESSAGE(MESSAGETITLE,MESSAGECONTENT,EMPLOYEEID,PUBLISHTIME) VALUES(?, ?, ?, ?)";
	private static final String FINDALLSQL = "SELECT * FROM TB_MESSAGE ORDER BY PUBLISHTIME DESC LIMIT ?,?";
	private static final String QUERYSQL = "SELECT * FROM TB_MESSAGE WHERE MESSAGEID = ?";
	private static final String FINDCOUNTSQL = "SELECT COUNT(*) FROM TB_MESSAGE";
	private static final String DELETESQL = "DELETE FROM TB_MESSAGE WHERE MESSAGEID = ?";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Message message = null;
	
	/**  
	 * 函数名： addMessage(Message message)
	 * 函数功能：发布消息 
	*/ 
	public void addMessage(Message message) {
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(ADDSQL);
			pstmt.setString(1, message.getMessageTitle());
			pstmt.setString(2, message.getMessageContent());
			pstmt.setInt(3, message.getEmployeeID());
			pstmt.setTimestamp(4, new Timestamp(message.getPublishTime().getTime()));
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
	}

	/**  
	 * 函数名：updateMessage(Message message)
	 * 函数功能：更新消息 
	*/ 
	public void updateMessage(Message message) {
		
	}

	/**  
	 * 函数名：deleteMessage(int MessageID)
	 * 函数功能：删除消息 
	*/ 
	public void deleteMessage(int messageID) {
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(DELETESQL);
			pstmt.setInt(1, messageID);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
	}
	
	/**  
	 * 函数名： findAllMessage(Page page)
	 * 函数功能：查询所有消息 
	*/ 
	public List<Message> findAllMessage(Page page) {
		List<Message> messageList = new ArrayList<Message>();
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(FINDALLSQL);
			pstmt.setInt(1, page.getBeginIndex());
			pstmt.setInt(2, page.getEveryPage());
			rs = pstmt.executeQuery();
			while(rs.next()) {
			    message = new Message();
				message.setMessageID(rs.getInt(1));
				message.setMessageTitle(rs.getString(2));
				message.setMessageContent(rs.getString(3));
				message.setEmployeeID(rs.getInt(4));
				message.setPublishTime(rs.getTimestamp(5));
				messageList.add(message);		//将消息放到列表中
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return messageList;
	}

	/**  
	 * 函数名：findMessageById(int messageID)
	 * 函数功能：通过消息ID查找消息
	*/ 
	public Message findMessageById(int messageID) {
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(QUERYSQL);
			pstmt.setInt(1, messageID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				message = new Message();
				message.setMessageID(rs.getInt(1));
				message.setMessageTitle(rs.getString(2));
				message.setMessageContent(rs.getString(3));
				message.setEmployeeID(rs.getInt(4));
				message.setPublishTime(rs.getTimestamp(5));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return message;
	}

	/**  
	 * 函数名：findAllCount()
	 * 函数功能：查询消息条数
	*/
	public int findAllCount() {
		int count = 0;
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(FINDCOUNTSQL);
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
