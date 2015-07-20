package com.jh.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**  
 * �����ƣ� DBConnection
 * �������� ���ݿ����Ӷ���
*/ 

public class DBConnection {
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";    //����������
	private static final String DBURL = "jdbc:mysql://10.1.12.24:3306/db_votemanage";
	private static final String DBUSER = "management";                 //���ݿ��û���
	private static final String DBPASSWORD = "manage";                 //���ݿ�����
	
	/**  
	 * �������� getConnection
	 * �������ܣ�������ݿ����ӷ��� 
	*/ 
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();			//�����������޷��ҵ���
		} catch(SQLException e) {
			e.printStackTrace();			//����SQL�쳣
		}
		return conn;
	}
	
	/**  
	 * �������� close(Connection conn)
	 * �������ܣ��ر����Ӷ��󷽷� 
	*/ 
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**  
	 * �������� close(PreparedStatement pstmt)
	 * �������ܣ��ر�Ԥ������󷽷� 
	*/ 
	public static void close(PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();			//�ر�pstmt���Ӷ���
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**  
	 * �������� close(ResultSet rs)
	 * �������ܣ��رս�������󷽷� 
	*/ 
	public static void close(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();			//�ر�rs���Ӷ���
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
