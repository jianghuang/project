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
 * 类名称： UpdateEmployeePlace
 * 类描述： 消息发布类，该类为Servlet
 * Servlet implementation class UpdateEmployeePlace
 */
@WebServlet("/UpdateEmployeePlace")
public class UpdateEmployeePlace extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		String employeePlace = request.getParameter("employeePlace");
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		if(employee == null) {
			request.setAttribute("error", "要更新信息必须首先进行身份认证！");
			dispatcher = servletContext.getRequestDispatcher("/page/statusRecognise.jsp");
		} else {
			if(employeePlace == null || "".equals(employeePlace)) {
				request.setAttribute("error", "请输入家庭住址！");
				dispatcher = servletContext.getRequestDispatcher("/page/updateEmployeePlace.jsp");
			} else {
				Employee employ = new Employee();
				employ.setEmployeePlace(employeePlace);
				
				employ.setEmployeeBirth(employee.getEmployeeBirth());
				employ.setEmployeePhone(employee.getEmployeePhone());
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
