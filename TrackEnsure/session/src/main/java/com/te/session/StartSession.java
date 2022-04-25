package com.te.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/hello-servlet", "/clear" })
public class StartSession extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// private int total;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		PrintWriter writer = response.getWriter();
//		writer.append("Served at: ").append(request.getContextPath()).append(System.lineSeparator());
//		writer.println(request.getParameter("btn"));
		String btnStr = request.getParameter("btn");
		request.setAttribute("123", "123");
		if("clear".equals(btnStr)) {
			request.getSession().invalidate();
		} 
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("numField"));
		// total += num;
		HttpSession session = request.getSession();
		if (session != null) {
			MyBean bean = (MyBean) session.getAttribute("bean");
			if (bean != null) {
				int total = bean.getNum() + num;
				bean.setNum(total);
				session.setAttribute("bean", bean);
			} else {
				
				session.setAttribute("bean", new MyBean(num));
			}
			Cookie[] cookies = request.getCookies();
			for(Cookie c : cookies) {
				System.out.println(c.getName());
				System.out.println(c.getValue());
			}
		}
		// request.setAttribute("bean", new MyBean(num));
		request.getRequestDispatcher("/result.jsp").forward(request, response);
	}
}