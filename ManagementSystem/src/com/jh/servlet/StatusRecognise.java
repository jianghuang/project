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
 * �����ƣ� StatusRecognse
 * �������� Ա�����ʶ���࣬����ΪServlet
 * Servlet implementation class StatusRecognise
 */
@WebServlet("/StatusRecognise")
public class StatusRecognise extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();		//���ServletContext
		RequestDispatcher dispatcher = null;
		String employeeID = request.getParameter("employeeID");
		String password = request.getParameter("password");
		if(employeeID == null || "".equals(employeeID)) {
			request.setAttribute("error", "������Ա����ţ�");
			dispatcher = servletContext.getRequestDispatcher("/page/statusRecognise.jsp");			//������תҳ��
		} else {
			if(password == null || "".equals(password)) {
				request.setAttribute("error", "������ϵͳ���");
				dispatcher = servletContext.getRequestDispatcher("/page/statusRecognise.jsp");
			} else {
				EmployeeDAO employeeDAO = EmployeeDAOFactory.getEmployeeDAOInstance();
				Employee employee = employeeDAO.findEmployeeById(Integer.parseInt(employeeID));		//��ѯԱ��
				if(employee == null) {
					request.setAttribute("error", "��Ա����Ų����ڣ�");
					dispatcher = servletContext.getRequestDispatcher("/page/statusRecognise.jsp");
				} else {
					if(password.equals(employee.getPassword())) {
						request.getSession().setAttribute("employee", employee);
						response.sendRedirect("../index.jsp");
						return;
					} else {
						request.setAttribute("error", "ϵͳ�����ȷ��");
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
