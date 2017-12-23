package com.tcy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tcy.service.ListService;


@SuppressWarnings("serial")
@WebServlet("/List.action")
public class ListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			// 接受页面的值
			String command = req.getParameter("command");
			String description = req.getParameter("description");
			System.out.println(command);
			ListService listService = new ListService();
			// 查询消息列表并传给页面
			req.setAttribute("messageList", listService.queryMessageList(command, description));
/*			// 向页面传值
			req.setAttribute("command", command);
			req.setAttribute("description", description);*/
			// 向页面跳转
			req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			this.doGet(req, resp);
		}
}