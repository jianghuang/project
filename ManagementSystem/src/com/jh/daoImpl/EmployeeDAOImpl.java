package com.jh.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.jh.bean.Employee;
import com.jh.dao.EmployeeDAO;
import com.jh.util.DBConnection;
import com.jh.util.Page;

/**  
 * 类名称： EmployeeDAOImpl
 * 类描述： 实现EmployeeDAO接口中方法
*/ 

public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String FINDBYIDSQL = "SELECT * FROM TB_EMPLOYEE WHERE EMPLOYEEID = ?";	
	private static final String ADDSQL = "INSERT INTO TB_EMPLOYEE(EMPLOYEEID, EMPLOYEENAME, EMPLOYEESEX, EMPLOYEEBIRTH, EMPLOYEEPHONE, EMPLOYEEPLACE, JOINTIME, PASSWORD, ISLEAD) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String DELETESQL = "DELETE FROM TB_EMPLOYEE WHERE EMPLOYEEID = ?";
	private static final String FINDALLSQL = "SELECT * FROM TB_EMPLOYEE ORDER BY EMPLOYEEID DESC LIMIT ?,?";
	private static final String FINDCOUNTSQL = "SELECT COUNT(*) FROM TB_EMPLOYEE";
	private static final String UPDATESQL = "UPDATE TB_EMPLOYEE SET EMPLOYEEBIRTH = ?, EMPLOYEEPHONE = ?, EMPLOYEEPLACE = ?, PASSWORD = ?, ISLEAD = ? WHERE EMPLOYEEID = ?";
	Connection conn = null;				
	PreparedStatement pstmt = null;								//声明预处理对象
	ResultSet rs = null;										//声明结果集对象
	Employee employee = null;
	
	/**  
	 * 函数名： addEmployee(Employee employee)
	 * 函数功能：添加员工信息
	*/ 
	public void addEmployee(Employee employee) {
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(ADDSQL);
			pstmt.setInt(1, employee.getEmployeeID());
			pstmt.setString(2, employee.getEmployeeName());
			pstmt.setBoolean(3, employee.isEmployeeSex());
			pstmt.setTimestamp(4, new Timestamp(employee.getEmployeeBirth().getTime()));
			pstmt.setString(5, employee.getEmployeePhone());
			pstmt.setString(6, employee.getEmployeePlace());
			pstmt.setTimestamp(7, new Timestamp(employee.getJoinTime().getTime()));
			pstmt.setString(8, employee.getPassword());
			pstmt.setBoolean(9, employee.isLead());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
	}
	
	/**  
	 * 函数名： updateEmployee(Employee employee)
	 * 函数功能：更新员工信息
	*/ 
	public void updateEmployee(Employee employee) {
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(UPDATESQL);
			pstmt.setTimestamp(1, new Timestamp(employee.getEmployeeBirth().getTime()));
			pstmt.setString(2, employee.getEmployeePhone());
			pstmt.setString(3, employee.getEmployeePlace());
			pstmt.setString(4, employee.getPassword());
			pstmt.setBoolean(5, employee.isLead());
			pstmt.setInt(6, employee.getEmployeeID());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
	}

	/**  
	 * 函数名： deleteEmployee(int employeeID)
	 * 函数功能：删除员工信息
	*/ 
	public void deleteEmployee(int employeeID) {
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(DELETESQL);
			pstmt.setInt(1, employeeID);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
	}

	/**  
	 * 函数名： findAllEmployee()
	 * 函数功能：查询所有员工信息
	*/ 
	public List<Employee> findAllEmployee(Page page) {
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(FINDALLSQL);
			pstmt.setInt(1, page.getBeginIndex());
			pstmt.setInt(2, page.getEveryPage());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				employee = new Employee();
				employee.setEmployeeID(rs.getInt(1));
				employee.setEmployeeName(rs.getString(2));
				employee.setEmployeeSex(rs.getBoolean(3));
				employee.setEmployeeBirth(rs.getDate(4));
				employee.setEmployeePhone(rs.getString(5));
				employee.setEmployeePlace(rs.getString(6));
				employee.setJoinTime(rs.getDate(7));
				employee.setLead(rs.getBoolean(9));
				employeeList.add(employee);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return employeeList;
	}
	
	/**  
	 * 函数名： findEmployeeById(int employeeID)
	 * 函数功能：按员工ID查询员工信息 
	*/ 
	public Employee findEmployeeById(int employeeID) {
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(FINDBYIDSQL);				//获得预处理对象并赋值
			pstmt.setInt(1, employeeID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				employee = new Employee();
				employee.setEmployeeID(rs.getInt(1));
				employee.setEmployeeName(rs.getString(2));
				employee.setEmployeeSex(rs.getBoolean(3));
				employee.setEmployeeBirth(rs.getDate(4));
				employee.setEmployeePhone(rs.getString(5));
				employee.setEmployeePlace(rs.getString(6));
				employee.setJoinTime(rs.getDate(7));
				employee.setPassword(rs.getString(8));
				employee.setLead(rs.getBoolean(9));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return employee;
	}
	
	/**  
	 * 函数名：findAllCount()
	 * 函数功能：查询员工记录总条数
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
