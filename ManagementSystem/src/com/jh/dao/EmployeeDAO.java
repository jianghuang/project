package com.jh.dao;

import java.util.List;

import com.jh.bean.Employee;
import com.jh.util.Page;

/**  
 * 接口名称： EmployeeDAO
 * 接口描述： 声明员工信息所有操作
*/ 

public interface EmployeeDAO {
	public void addEmployee(Employee employee);				//定义添加员工信息方法
	public void updateEmployee(Employee employee);			//定义修改员工信息方法
	public void deleteEmployee(int employeeID);				//定义删除员工信息方法
	public List<Employee> findAllEmployee(Page page);		//定义查询所有员工信息方法
	public Employee findEmployeeById(int employeeID);		//按ID查询员工信息
	public int findAllCount();								//查询员工激记录总条数
}
