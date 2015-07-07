package com.jh.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.jh.bean.Employee;
import com.jh.dao.EmployeeDAO;
import com.jh.factory.EmployeeDAOFactory;
import com.jh.util.DBConnection;

/**
 * 类名称： StatusRecognse
 * 类描述： 员工身份识别类，该类为Servlet
 * Servlet implementation class StatusRecognise
 */
@WebServlet("/StatusRecognise")
public class StatusRecognise extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();		//获得ServletContext
		RequestDispatcher dispatcher = null;
		String employeeID = request.getParameter("employeeID");
		String password = request.getParameter("password");
		if(employeeID == null || "".equals(employeeID)) {
			request.setAttribute("error", "请输入员工编号！");
			dispatcher = servletContext.getRequestDispatcher("/page/statusRecognise.jsp");			//设置跳转页面
		} else {
			if(password == null || "".equals(password)) {
				request.setAttribute("error", "请输入系统口令！");
				dispatcher = servletContext.getRequestDispatcher("/page/statusRecognise.jsp");
			} else {
				EmployeeDAO employeeDAO = EmployeeDAOFactory.getEmployeeDAOInstance();
				Employee employee = employeeDAO.findEmployeeById(Integer.parseInt(employeeID));		//查询员工
				if(employee == null) {
					request.setAttribute("error", "该员工编号不存在！");
					dispatcher = servletContext.getRequestDispatcher("/page/statusRecognise.jsp");
				} else {
					if(password.equals(employee.getPassword())) {
						request.getSession().setAttribute("employee", employee);
						response.sendRedirect("../index.jsp");
						return;
					} else {
						request.setAttribute("error", "系统口令不正确！");
						dispatcher = servletContext.getRequestDispatcher("/page/statusRecognise.jsp");
					}
				}
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
