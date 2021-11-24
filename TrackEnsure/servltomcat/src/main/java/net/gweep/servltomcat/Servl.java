package net.gweep.servltomcat;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.gweep.servltomcat.beans.FormulaBean;

@WebServlet(urlPatterns = {"/", "/action"})
public class Servl extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	String message1;
	
	public void init() {
		message1 = "init";
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write(message1 + System.lineSeparator() + "<h1>TrackEnsure tomcat test!</h1>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FormulaBean b = new FormulaBean(req.getParameter("message"));
		resp.getWriter().write(req.getParameter("message") + "="+ b.getResult());

	}

	public void destroy() {
		message1 = "close";
	}
}
