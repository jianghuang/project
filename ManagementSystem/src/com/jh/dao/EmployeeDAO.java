package com.jh.dao;

import java.util.List;

import com.jh.bean.Employee;
import com.jh.util.Page;

/**  
 * �ӿ����ƣ� EmployeeDAO
 * �ӿ������� ����Ա����Ϣ���в���
*/ 

public interface EmployeeDAO {
	public void addEmployee(Employee employee);				//�������Ա����Ϣ����
	public void updateEmployee(Employee employee);			//�����޸�Ա����Ϣ����
	public void deleteEmployee(int employeeID);				//����ɾ��Ա����Ϣ����
	public List<Employee> findAllEmployee(Page page);		//�����ѯ����Ա����Ϣ����
	public Employee findEmployeeById(int employeeID);		//��ID��ѯԱ����Ϣ
	public int findAllCount();								//��ѯԱ������¼������
}
