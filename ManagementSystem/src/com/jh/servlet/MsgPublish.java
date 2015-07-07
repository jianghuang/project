package com.jh.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jh.bean.Employee;
import com.jh.bean.Message;
import com.jh.dao.MessageDAO;
import com.jh.factory.MessageDAOFactory;

/**
 * �����ƣ� MsgPublish
 * �������� ��Ϣ�����࣬����ΪServlet
 * Servlet implementation class MsgPublish
 */
@WebServlet("/MsgPublish")
public class MsgPublish extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");				//���ñ����ʽ
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		//���sesion��Χemployee������ȷ�����ĸ�Ա����������Ϣ
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		if(employee == null) {
			request.setAttribute("error", "Ҫ������Ϣ�������Ƚ��������֤��");
			dispatcher = servletContext.getRequestDispatcher("/page/statusRecognise.jsp");
		} else {
			if(title == null || "".equals(title)) {
				request.setAttribute("error", "����������Ϣ����");
				dispatcher = servletContext.getRequestDispatcher("/page/publishNewMsg.jsp");
			} else {
				Message message = new Message();
				message.setEmployeeID(employee.getEmployeeID());
				message.setMessageTitle(title);
				message.setMessageContent(content);
				message.setPublishTime(new Date());
				MessageDAO messageDAO = MessageDAOFactory.getMessageDAOInstance();
				messageDAO.addMessage(message);
				dispatcher = servletContext.getRequestDispatcher("/GetMessageList");
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
