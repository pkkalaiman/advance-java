package com.xworkz.webseries;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 2, urlPatterns = "/Movies")
public class Movies extends HttpServlet {

	public Movies() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Running in WebSeries ...........");

		String name = req.getParameter("WebSerisName");
		String Lang = req.getParameter("Lang");
		String episod = req.getParameter("Episodes");
		String ott = req.getParameter("OTT");
		String budget = req.getParameter("Budget");

		System.out.println(name);
		System.out.println(Lang);
		System.out.println(episod);
		System.out.println(ott);
		System.out.println(budget);

		PrintWriter writ = resp.getWriter();
		writ.print("<html>");
		writ.print("<body>");
		writ.print("<h1>");
		writ.print("<spam style= 'color :red'>");

		writ.print("Printing name =" + name + " " + " Movie Printing Successfully");

		writ.print("</spam>");
		writ.print("</h1>");
		writ.print("</body>");
		writ.print("</html>");

		resp.setContentType("text/html");
	}

}
