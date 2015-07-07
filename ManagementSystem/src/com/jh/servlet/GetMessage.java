package com.jh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jh.bean.Criticism;
import com.jh.bean.Message;
import com.jh.bean.Reply;
import com.jh.dao.CriticismDAO;
import com.jh.dao.MessageDAO;
import com.jh.dao.ReplyDAO;
import com.jh.factory.CriticismDAOFactory;
import com.jh.factory.MessageDAOFactory;
import com.jh.factory.ReplyDAOFactory;
import com.jh.util.Page;
import com.jh.util.PageUtil;

/**
 * 类名称： GetMessage
 * 类描述： 显示消息类，该类为Servlet
 * Servlet implementation class GetMessage
 */
@WebServlet("/GetMessage")
public class GetMessage extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int messageID = Integer.parseInt(request.getParameter("messageID"));
		MessageDAO messageDAO = MessageDAOFactory.getMessageDAOInstance();
		Message message = messageDAO.findMessageById(messageID);
		request.setAttribute("message", message);
		
		//获得该消息对应的回复
		int currentPage = 0;
		String currentPageStr = request.getParameter("currentPage");
		if(currentPageStr == null || "".equals(currentPageStr)) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(currentPageStr);
		}
		ReplyDAO replyDAO = ReplyDAOFactory.getReplyDAOInstance();
		Page page = PageUtil.createPage(5, replyDAO.findCountByMsgID(messageID), currentPage);
		List<Reply> replyList = replyDAO.findReplayByMsgID(messageID, page);
		request.setAttribute("replyList", replyList);
		request.setAttribute("page", page);
		
		//获得该消息对象的批复
		CriticismDAO criticismDAO = CriticismDAOFactory.getCriticismDAOInstance();
		Criticism criticism = criticismDAO.findCriticismByMsgID(messageID);
		request.setAttribute("criticism", criticism);
		
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/page/showMsg.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
