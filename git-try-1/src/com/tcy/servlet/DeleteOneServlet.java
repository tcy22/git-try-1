package com.tcy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcy.service.MaintainService;

/**
 * 单条删除控制层
 */
@SuppressWarnings("serial")
@WebServlet("/DeleteOne.action")
public class DeleteOneServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 接受页面的值
		String id = req.getParameter("id");
		MaintainService maintainService = new MaintainService();
		maintainService.deleteOne(id);
		System.out.println(id);
		// 向页面跳转
		req.getRequestDispatcher("/List.action").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
