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
 * 类名称： Registered
 * 类描述： 员工身份识别类，该类为Servlet
 * Servlet implementation class Registered
 */
@WebServlet("/Registered")
public class Registered extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();		//获得ServletContext
		RequestDispatcher dispatcher = null;
		String employeeID = request.getParameter("employeeID");
		String employeeName = request.getParameter("employeeName");
		String employeeSex = request.getParameter("employeeSex");
		String employeeBirth = request.getParameter("employeeBirth");
		String employeePhone = request.getParameter("employeePhone");
		String employeePlace = request.getParameter("employeePlace");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String isLead = request.getParameter("isLead");
		EmployeeDAO employeeDAO = EmployeeDAOFactory.getEmployeeDAOInstance();
		Employee employee = new Employee();
		if(employeeID == null || "".equals(employeeID)) {
			request.setAttribute("error", "请输入员工编号！");
			dispatcher = servletContext.getRequestDispatcher("/page/registered.jsp");			//设置跳转页面
		} else {
			employee = employeeDAO.findEmployeeById(Integer.parseInt(employeeID));
			if(employee == null) {
				if(employeeName == null || "".equals(employeeName)) {
					request.setAttribute("error", "请输入姓名！");
					dispatcher = servletContext.getRequestDispatcher("/page/registered.jsp");
				} else {
					if(employeeSex == null || "".equals(employeeSex)) {
						request.setAttribute("error", "请选择性别！");
						dispatcher = servletContext.getRequestDispatcher("/page/registered.jsp");
					} else {
						if(employeeBirth == null || "".equals(employeeBirth)) {
							request.setAttribute("error", "请输入出生日期！");
							dispatcher = servletContext.getRequestDispatcher("/page/registered.jsp");
						} else {
							if(employeePhone == null || "".equals(employeePhone)) {
								request.setAttribute("error", "请输入联系电话！");
								dispatcher = servletContext.getRequestDispatcher("/page/registered.jsp");
							} else {
								if(employeePlace == null || "".equals(employeePlace)) {
									request.setAttribute("error", "请输入家庭住址！");
									dispatcher = servletContext.getRequestDispatcher("/page/registered.jsp");
								} else {
									if(isLead == null || "".equals(isLead)) {
										request.setAttribute("error", "请选择是否是领导！");
										dispatcher = servletContext.getRequestDispatcher("/page/registered.jsp");
									} else {
										if(password1 == null || "".equals(password1) || password2 == null || "".equals(password2)) {
											request.setAttribute("error", "请输入口令！");
											dispatcher = servletContext.getRequestDispatcher("/page/registered.jsp");
										} else if(password1.equals(password2)) {
											boolean sex = false;
											if("男".equals(employeeSex)) {
												sex = true;
											}
											boolean  lead = false;
											if("是".equals(isLead)) {
												lead = true;
											}
											Employee employ = new Employee();
											employ.setEmployeeID(Integer.parseInt(employeeID));
											employ.setEmployeeName(employeeName);
											employ.setEmployeeSex(sex);
											try {
												employ.setEmployeeBirth(new SimpleDateFormat("yyyy-MM-dd").parse(employeeBirth));
											} catch (ParseException e) {
												e.printStackTrace();
											}
											employ.setEmployeePhone(employeePhone);
											employ.setEmployeePlace(employeePlace);
											employ.setJoinTime(new Date());
											employ.setPassword(password1);
											employ.setLead(lead);
											employeeDAO.addEmployee(employ);
											dispatcher = servletContext.getRequestDispatcher("/page/statusRecognise.jsp");
										} else {
											request.setAttribute("error", "请输入相同口令！");
											dispatcher = servletContext.getRequestDispatcher("/page/registered.jsp");
										}
									}
								}
							}
						}
					}
				}
			} else {
				request.setAttribute("error", "该ID已经被注册！");
				dispatcher = servletContext.getRequestDispatcher("/page/registered.jsp");
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
