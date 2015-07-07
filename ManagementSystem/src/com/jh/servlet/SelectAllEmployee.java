package com.jh.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

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
import com.jh.util.Page;
import com.jh.util.PageUtil;

/**
 * 类名称： SelectAllEmployee
 * 类描述： 获取消息类，该类为Servlet
 * Servlet implementation class SelectAllEmployee
 */
@WebServlet("/SelectAllEmployee")
public class SelectAllEmployee extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 0;
		String currentPageStr = request.getParameter("currentPage");		//获取当前页
		if(currentPageStr == null || "".equals(currentPageStr)) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(currentPageStr);
		}
		
		EmployeeDAO employeeDAO = EmployeeDAOFactory.getEmployeeDAOInstance();
		Page page = PageUtil.createPage(5, employeeDAO.findAllCount(), currentPage);
		List<Employee> employeeList = employeeDAO.findAllEmployee(page);
		request.setAttribute("employeeList", employeeList);
		request.setAttribute("page", page);
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/page/selectAllEmployee.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
