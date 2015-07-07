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
 * 类名称： DeleteEmployee
 * 类描述： 员工身份注销类，该类为Servlet
 * Servlet implementation class DeleteEmployee
 */
@WebServlet("/DeleteEmployee")
public class DeleteEmployee extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		String employeeID = request.getParameter("employeeID");
		if(employeeID == null || "".equals(employeeID)) {
			request.setAttribute("error", "请输入员工编号！");
			dispatcher = servletContext.getRequestDispatcher("/page/deleteEmployee.jsp");	
		} else {
			EmployeeDAO employeeDAO = EmployeeDAOFactory.getEmployeeDAOInstance();
			Employee employee = employeeDAO.findEmployeeById(Integer.parseInt(employeeID));	
			if(employee == null) {
				request.setAttribute("error", "该员工不存在！");
				dispatcher = servletContext.getRequestDispatcher("/page/deleteEmployee.jsp");
			} else {
				employeeDAO.deleteEmployee(Integer.parseInt(employeeID));
				response.sendRedirect("page/statusRecognise.jsp");
				return;
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
