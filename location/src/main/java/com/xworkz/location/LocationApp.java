package com.xworkz.location;

import java.io.IOException; 
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 6, urlPatterns = "/location")
public class LocationApp extends HttpServlet {

	public LocationApp() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Running init in LocationApp...........");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Running doPost in LocationApp........");

		String name = req.getParameter("UserName");
		String email = req.getParameter("UserMail");
		String startpoint = req.getParameter("StartingPoint");
		String destination = req.getParameter("Destination");
		String gender = req.getParameter("Gender");
		
		Long convertedName=Long.parseLong(name);
		
		Long convertedDestination=Long.parseLong(destination);

		System.out.println(name);
		System.out.println(email);
		System.out.println(startpoint);
		System.out.println(destination);
		System.out.println(gender);

		PrintWriter writer = resp.getWriter();
		
		writer.print("<html>");
		writer.print("<body>");
		writer.print("<h1>");
		
		if(convertedName >3) {
		writer.print("<spam style = 'color : green'>");
		writer.print("Name is Valid");
		
		}else {
			writer.print("<spam style='color:blue'>");
			writer.print("Name is Invalid");
		}
		
		
		if(convertedDestination >10) {
			 
			writer.print("<spam style= 'color : yellow'>");
			writer.print("Destinataion is Valid");
		}else {
			
			writer.print("<spam style='color : red'>");
			writer.print("Destination is Invalide");
		}
		
		
		resp.setContentType("text/html");

	}

}
