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
 * 类名称： UpdateEmployeeBirth
 * 类描述： 消息发布类，该类为Servlet
 * Servlet implementation class UpdateEmployeeBirth
 */
@WebServlet("/UpdateEmployeeBirth")
public class UpdateEmployeeBirth extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		String employeeBirth = request.getParameter("employeeBirth");
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		if(employee == null) {
			request.setAttribute("error", "要更新信息必须首先进行身份认证！");
			dispatcher = servletContext.getRequestDispatcher("/page/statusRecognise.jsp");
		} else {
			if(employeeBirth == null || "".equals(employeeBirth)) {
				request.setAttribute("error", "请输入出生日期！");
				dispatcher = servletContext.getRequestDispatcher("/page/updateEmployeeBirth.jsp");
			} else {
				Employee employ = new Employee();
				try {
					employ.setEmployeeBirth(new SimpleDateFormat("yyyy-MM-dd").parse(employeeBirth));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				employ.setEmployeePhone(employee.getEmployeePhone());
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
