package com.jh.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**  
 * 类名称： DBConnection
 * 类描述： 数据库连接对象
*/ 

public class DBConnection {
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";    //驱动类类名
	private static final String DBURL = "jdbc:mysql://10.1.12.24:3306/db_votemanage";
	private static final String DBUSER = "management";                 //数据库用户名
	private static final String DBPASSWORD = "manage";                 //数据库密码
	
	/**  
	 * 函数名： getConnection
	 * 函数功能：获得数据库连接方法 
	*/ 
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();			//捕获驱动类无法找到异
		} catch(SQLException e) {
			e.printStackTrace();			//捕获SQL异常
		}
		return conn;
	}
	
	/**  
	 * 函数名： close(Connection conn)
	 * 函数功能：关闭连接对象方法 
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
	 * 函数名： close(PreparedStatement pstmt)
	 * 函数功能：关闭预处理对象方法 
	*/ 
	public static void close(PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();			//关闭pstmt连接对象
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**  
	 * 函数名： close(ResultSet rs)
	 * 函数功能：关闭结果集对象方法 
	*/ 
	public static void close(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();			//关闭rs连接对象
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
