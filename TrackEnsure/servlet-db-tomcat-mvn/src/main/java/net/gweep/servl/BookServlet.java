package net.gweep.servl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.gweep.servl.config.Provider;
import net.gweep.servl.dao.BookDao;
import net.gweep.servl.dao.jdbc.JdbcBookDao;
import net.gweep.servl.entity.Book;
import net.gweep.servl.entity.Genre;

@WebServlet("/")
public class BookServlet extends HttpServlet {

	// for serialization ?
	private static final long serialVersionUID = 5310086333111502737L;
	private BookDao bookDao;

	public BookServlet() {
		this.bookDao = new JdbcBookDao(new Provider());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equalsIgnoreCase("/new")) {
			showNewForm(request, response);
		} else if (action.equalsIgnoreCase("/add")) {
			addBook(request, response);
		} else if (action.equalsIgnoreCase("/edit")) {
			showEditForm(request, response);
		} else if (action.equalsIgnoreCase("/update")) {
			updateBook(request, response);
		} else if (action.equalsIgnoreCase("/delete")) {
			deleteBook(request, response);
		} else {
			getBooks(request, response);
		}
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("book-form.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		Book bookDb = bookDao.getById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("book-form.jsp");
		request.setAttribute("book", bookDb);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void addBook(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		Genre genre = Genre.valueOf(request.getParameter("genre"));
		int pageCount = Integer.parseInt(request.getParameter("pageCount"));
		Book book = new Book(name, author, genre, pageCount);
		bookDao.add(book);
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getBooks(HttpServletRequest request, HttpServletResponse response) {
		List<Book> books = bookDao.getAll();
		request.setAttribute("books", books);
		RequestDispatcher dispatcher = request.getRequestDispatcher("book-list.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void updateBook(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		Genre genre = Genre.valueOf(request.getParameter("genre"));
		int pageCount = Integer.parseInt(request.getParameter("pageCount"));
		Book book = new Book(id, name, author, genre, pageCount);
		bookDao.update(book);
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void deleteBook(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		bookDao.deleteById(id);
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}