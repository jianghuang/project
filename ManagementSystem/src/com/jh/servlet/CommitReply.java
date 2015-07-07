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
import com.jh.bean.Reply;
import com.jh.dao.ReplyDAO;
import com.jh.factory.ReplyDAOFactory;

/**
 * 类名称： CommitReply
 * 类描述： 消息发布类，该类为Servlet
 * Servlet implementation class CommitReply
 */
@WebServlet("/CommitReply")
public class CommitReply extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		String replyContent = request.getParameter("replyContent");
		int messageID = Integer.parseInt(request.getParameter("messageID"));
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		if(employee == null) {
			request.setAttribute("error", "要进行身份认证才能回复！");
			dispatcher = servletContext.getRequestDispatcher("/page/statusRecognise.jsp");
		} else {
			if(replyContent == null || "".equals(replyContent)) {
				request.setAttribute("error", "必须输入回复内容");
			} else {
				Reply reply = new Reply();
				reply.setReplyContent(replyContent);
				reply.setMessageID(messageID);
				reply.setEmployeeID(employee.getEmployeeID());
				reply.setReplyTime(new Date());
				ReplyDAO replyDAO = ReplyDAOFactory.getReplyDAOInstance();
				replyDAO.addReply(reply);
			}
		}
		dispatcher = servletContext.getRequestDispatcher("/GetMessage?messageID=" + messageID);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
