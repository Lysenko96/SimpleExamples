package com.te.myservletmvn;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.te.myservletmvn.beans.BookBean;
import com.te.myservletmvn.dao.JdbcBookDao;
import com.te.myservletmvn.entity.Book;
import com.te.myservletmvn.provider.Provider;

@WebServlet(urlPatterns = { "/start", "/result"})
public class StartServlet extends HttpServlet {

	private static final long serialVersionUID = 272393805775687730L;
	private String message;
	private Connection connection;

	public void init() {
		message = "Start page!";
		connection = Provider.getInstance().getConnection();
		if (connection != null) {
			message = "Database connected!";
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write(message);
		List<Book> books = new JdbcBookDao().findAll();
		req.setAttribute("bookBean", new BookBean(books));
		req.getRequestDispatcher("/book.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int pageCount = Integer.parseInt(req.getParameter("pageCount"));
		System.out.println(pageCount);
		Optional<Book> b = new JdbcBookDao().findMoreByPageCount(pageCount);
		System.out.println(b);
		System.out.println(b.get());
		//if (b.isPresent()) {
			req.setAttribute("book", b.get());
			req.getRequestDispatcher("/result.jsp").forward(req, resp);
		//} 
//		else {
//			req.getRequestDispatcher("null.jsp").forward(req, resp);
//		}
	}

	public void destroy() {

	}
}
