package com.xworkz.king;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 3, urlPatterns = "/King")
public class KingIndia extends HttpServlet {

	public KingIndia() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Running In Do Get King Of India................");

		String name = req.getParameter("King Name");
		String region = req.getParameter("Region");
		String noOfQueen = req.getParameter("noOfQueen");
		String dob = req.getParameter("DOB");
		String dod = req.getParameter("Date");

		System.out.println(name);
		System.out.println(region);
		System.out.println(noOfQueen);
		System.out.println(dob);
		System.out.println(dod);

		PrintWriter print = resp.getWriter();
		print.print("<html>");
		print.print("<body>");
		print.print("<h1>");
		print.print("<spam style='color : yellow'>");
		print.print("Name is Created ="+name + " "+ "Printing name Successfully.........");
		print.print("</spam>");
		print.print("</h1>");
		print.print("</body>");
		print.print("</html>");
		
		resp.setContentType("text/html");

	}
}
