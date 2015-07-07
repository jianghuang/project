package com.jh.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
 * �����ƣ� UpdateEmployeePhone
 * �������� ��Ϣ�����࣬����ΪServlet
 * Servlet implementation class UpdateEmployeePhone
 */
@WebServlet("/UpdateEmployeePhone")
public class UpdateEmployeePhone extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		String employeePhone = request.getParameter("employeePhone");
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		if(employee == null) {
			request.setAttribute("error", "Ҫ������Ϣ�������Ƚ��������֤��");
			dispatcher = servletContext.getRequestDispatcher("/page/statusRecognise.jsp");
		} else {
			if(employeePhone == null || "".equals(employeePhone)) {
				request.setAttribute("error", "��������ϵ�绰��");
				dispatcher = servletContext.getRequestDispatcher("/page/updateEmployeePhone.jsp");
			} else {
				Employee employ = new Employee();
				employ.setEmployeePhone(employeePhone);
				
				employ.setEmployeeBirth(employee.getEmployeeBirth());
				employ.setEmployeePlace(employee.getEmployeePlace());
				employ.setPassword(employee.getPassword());
				employ.setLead(employee.isLead());
				employ.setEmployeeID(employee.getEmployeeID());
				
				EmployeeDAO employeeDAO = EmployeeDAOFactory.getEmployeeDAOInstance();
				employeeDAO.updateEmployee(employ);
				dispatcher = servletContext.getRequestDispatcher("/page/statusRecognise.jsp");
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
