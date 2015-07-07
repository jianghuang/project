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
 * �����ƣ� Registered
 * �������� Ա�����ʶ���࣬����ΪServlet
 * Servlet implementation class Registered
 */
@WebServlet("/Registered")
public class Registered extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();		//���ServletContext
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
			request.setAttribute("error", "������Ա����ţ�");
			dispatcher = servletContext.getRequestDispatcher("/page/registered.jsp");			//������תҳ��
		} else {
			employee = employeeDAO.findEmployeeById(Integer.parseInt(employeeID));
			if(employee == null) {
				if(employeeName == null || "".equals(employeeName)) {
					request.setAttribute("error", "������������");
					dispatcher = servletContext.getRequestDispatcher("/page/registered.jsp");
				} else {
					if(employeeSex == null || "".equals(employeeSex)) {
						request.setAttribute("error", "��ѡ���Ա�");
						dispatcher = servletContext.getRequestDispatcher("/page/registered.jsp");
					} else {
						if(employeeBirth == null || "".equals(employeeBirth)) {
							request.setAttribute("error", "������������ڣ�");
							dispatcher = servletContext.getRequestDispatcher("/page/registered.jsp");
						} else {
							if(employeePhone == null || "".equals(employeePhone)) {
								request.setAttribute("error", "��������ϵ�绰��");
								dispatcher = servletContext.getRequestDispatcher("/page/registered.jsp");
							} else {
								if(employeePlace == null || "".equals(employeePlace)) {
									request.setAttribute("error", "�������ͥסַ��");
									dispatcher = servletContext.getRequestDispatcher("/page/registered.jsp");
								} else {
									if(isLead == null || "".equals(isLead)) {
										request.setAttribute("error", "��ѡ���Ƿ����쵼��");
										dispatcher = servletContext.getRequestDispatcher("/page/registered.jsp");
									} else {
										if(password1 == null || "".equals(password1) || password2 == null || "".equals(password2)) {
											request.setAttribute("error", "��������");
											dispatcher = servletContext.getRequestDispatcher("/page/registered.jsp");
										} else if(password1.equals(password2)) {
											boolean sex = false;
											if("��".equals(employeeSex)) {
												sex = true;
											}
											boolean  lead = false;
											if("��".equals(isLead)) {
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
											request.setAttribute("error", "��������ͬ���");
											dispatcher = servletContext.getRequestDispatcher("/page/registered.jsp");
										}
									}
								}
							}
						}
					}
				}
			} else {
				request.setAttribute("error", "��ID�Ѿ���ע�ᣡ");
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
