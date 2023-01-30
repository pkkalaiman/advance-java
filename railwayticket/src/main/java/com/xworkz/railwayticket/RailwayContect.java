package com.xworkz.railwayticket;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 10, urlPatterns = "/railway")
public class RailwayContect extends HttpServlet {

	public RailwayContect() {
		System.out.println("Created : " + this.getClass().getSimpleName());
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Running in Init Method RailwayContec..........");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Running doPost in Railway Servlet................");

		String name = req.getParameter("Name");
		String DeportmentWebsit = req.getParameter("Website");
		String StartingTime = req.getParameter("StartingTiming");
		String dateTime = req.getParameter("DateTime");
		String TicketPrice = req.getParameter("TicketPrice");

		System.out.println("Name: "+name);
		System.out.println("RailwayDept: "+DeportmentWebsit);
		System.out.println("Train Starting: "+StartingTime);
		System.out.println("Timing: "+dateTime);
		System.out.println("Price: "+TicketPrice);

		PrintWriter writer = resp.getWriter();

		writer.print("<html>");
		writer.print("<h1>");

		if (name.length() > 3 && DeportmentWebsit.length() > 12 && StartingTime.length() > 2 && dateTime.length() > 0
				&& TicketPrice.length() > 1000) {
			writer.print("<spam style='color : yellow'>");
			writer.print("Signed Up Seccessfulyy...");
			writer.print("</spam>");

		} else {
			writer.print("<spam style='color :blue'>");
			writer.print("Please Enter Valid Information");
			writer.print("</spam>");
		}

		writer.print("</h1>");
		writer.print("<a href=\"index.html\">Home Page</a>");
		writer.print("<br>");
		writer.print("<a href=\"railwaycontact.html\">sign in again</a>");
		writer.print("</spam>");
		writer.print("</html>");

		resp.setContentType("text/html");
	}

}
