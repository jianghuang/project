package com.jh.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jh.bean.Employee;
import com.jh.dao.EmployeeDAO;
import com.jh.factory.EmployeeDAOFactory;

/**
 * �����ƣ� UpdateEmployeePassword
 * �������� ��Ϣ�����࣬����ΪServlet
 * Servlet implementation class UpdateEmployeePassword
 */
@WebServlet("/UpdateEmployeePassword")
public class UpdateEmployeePassword extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		if(employee == null) {
			request.setAttribute("error", "Ҫ������Ϣ�������Ƚ��������֤��");
			dispatcher = servletContext.getRequestDispatcher("/page/statusRecognise.jsp");
		} else {
			if(password1 == null || "".equals(password1) || password2 == null || "".equals(password2)) {
				request.setAttribute("error", "������ϵͳ���");
				dispatcher = servletContext.getRequestDispatcher("/page/updateEmployeePassword.jsp");
			} else if(password1.equals(password2)) {
				Employee employ = new Employee();
				employ.setPassword(password1);
				
				employ.setEmployeeBirth(employee.getEmployeeBirth());
				employ.setEmployeePhone(employee.getEmployeePhone());
				employ.setEmployeePlace(employee.getEmployeePlace());
				employ.setLead(employee.isLead());
				employ.setEmployeeID(employee.getEmployeeID());
				
				EmployeeDAO employeeDAO = EmployeeDAOFactory.getEmployeeDAOInstance();
				employeeDAO.updateEmployee(employ);
				dispatcher = servletContext.getRequestDispatcher("/page/statusRecognise.jsp");
			} else {
				request.setAttribute("error", "����������һ�£�");
				dispatcher = servletContext.getRequestDispatcher("/page/updateEmployeePassword.jsp");
			}
		}
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
