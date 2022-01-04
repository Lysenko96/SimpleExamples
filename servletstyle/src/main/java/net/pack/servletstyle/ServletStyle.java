package net.pack.servletstyle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.pack.servletstyle.beans.ShopRepo;

@WebServlet("/ServletStyle")
public class ServletStyle extends HttpServlet {

	private static final long serialVersionUID = -3832728198631730082L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		process(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		process(request, response);
	}

	public void process(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		// session.invalidate();
		

		//ShopRepo repo = (ShopRepo) session.getAttribute("shopRepo");
	
//		String name = request.getParameter("nameProduct");
//		int countProduct = Integer.parseInt(request.getParameter("countProduct"));
//		
//		if(repo == null) {
//			repo = new ShopRepo(name, countProduct);
//			System.out.println(repo);
//		}
//		
//		session.setAttribute("repo", repo);
//		try {
//			getServletContext().getRequestDispatcher("/showShopRepo.jsp").forward(request, response);
//		} catch (ServletException | IOException e1) {
//			e1.printStackTrace();
//		}

//		Integer count = (Integer) session.getAttribute("count");
//		if (count == null) {
//			session.setAttribute("count", 1);
//			count = (Integer) session.getAttribute("count");
//		} else {
//			session.setAttribute("count", count + 1);
//			count = (Integer) session.getAttribute("count");
//		}
//		//String name = request.getParameter("name");
//		try {
//			PrintWriter writer = response.getWriter();
//			writer.append("<html>");
//			writer.append("Count: ").append("" + count);
//			writer.append("</html>");
		// url indexStyle.jsp
		// response.sendRedirect(request.getContextPath() + "/indexStyle.jsp");
		// url StartServlet
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/indexStyle.jsp");
//			dispatcher.forward(request, response);

//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

}
