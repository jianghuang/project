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

import com.jh.bean.Message;
import com.jh.dao.MessageDAO;
import com.jh.factory.MessageDAOFactory;
import com.jh.util.Page;
import com.jh.util.PageUtil;

/**
 * 类名称： GetMessageList
 * 类描述： 获取消息类，该类为Servlet
 * Servlet implementation class GetMessageList
 */
@WebServlet("/GetMessageList")
public class GetMessageList extends HttpServlet {
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
		
		MessageDAO messageDAO = MessageDAOFactory.getMessageDAOInstance();
		Page page = PageUtil.createPage(5, messageDAO.findAllCount(), currentPage);
		List<Message> messageList = messageDAO.findAllMessage(page);
		request.setAttribute("messageList", messageList);
		request.setAttribute("page", page);
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/page/msgList.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
