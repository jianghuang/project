package com.jh.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * 类名称： UpdateEmployee
 * 类描述： 消息发布类，该类为Servlet
 * Servlet implementation class UpdateEmployee
 */
@WebServlet("/UpdateEmployee")
public class UpdateEmployee extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		String employeeBirth = request.getParameter("employeeBirth");
		String employeePhone = request.getParameter("employeePhone");
		String employeePlace = request.getParameter("employeePlace");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String isLead = request.getParameter("isLead");
		
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		if(employee == null) {
			request.setAttribute("error", "要发布消息必须首先进行身份认证！");
			dispatcher = servletContext.getRequestDispatcher("/page/statusRecognise.jsp");
		} else {
			if(employeeBirth == null || "".equals(employeeBirth)) {
				request.setAttribute("error", "请输入出生日期！");
				dispatcher = servletContext.getRequestDispatcher("/page/updateEmployee.jsp");
			} else {
				if(employeePhone == null || "".equals(employeePhone)) {
					request.setAttribute("error", "请输入联系电话！");
					dispatcher = servletContext.getRequestDispatcher("/page/updateEmployee.jsp");
				} else {
					if(employeePlace == null || "".equals(employeePlace)) {
						request.setAttribute("error", "请输入家庭住址！");
						dispatcher = servletContext.getRequestDispatcher("/page/updateEmployee.jsp");
					} else {
						if(isLead == null || "".equals(isLead)) {
							request.setAttribute("error", "请选择是否是领导！");
							dispatcher = servletContext.getRequestDispatcher("/page/updateEmployee.jsp");
						} else {
							if(password1 == null || "".equals(password1) || password2 == null || "".equals(password2)) {
								request.setAttribute("error", "请输入口令！");
								dispatcher = servletContext.getRequestDispatcher("/page/updateEmployee.jsp");
							} else if(password1.equals(password2)) {
								boolean  lead = false;
								if("是".equals(isLead)) {
									lead = true;
								}
								Employee employ = new Employee();
								try {
									employ.setEmployeeBirth(new SimpleDateFormat("yyyy-MM-dd").parse(employeeBirth));
								} catch (ParseException e) {
									e.printStackTrace();
								}
								employ.setEmployeePhone(employeePhone);
								employ.setEmployeePlace(employeePlace);
								employ.setPassword(password1);
								employ.setLead(lead);
								employ.setEmployeeID(employee.getEmployeeID());
								
								EmployeeDAO employeeDAO = EmployeeDAOFactory.getEmployeeDAOInstance();
								employeeDAO.updateEmployee(employ);
								dispatcher = servletContext.getRequestDispatcher("/page/statusRecognise.jsp");
							} else {
								request.setAttribute("error", "请输入相同口令！");
								dispatcher = servletContext.getRequestDispatcher("/page/updateEmployee.jsp");
							}
						}
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
