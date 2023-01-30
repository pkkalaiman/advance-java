package com.xworkz.location;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 8, urlPatterns = "/contact")
public class Contact extends HttpServlet {

	public Contact() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Running init Contact.........");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Running doPost ContactServlet.........");

		String name = req.getParameter("Name");
		String eMail = req.getParameter("eMail");
		String Mobile = req.getParameter("Mobile");
		String Comments = req.getParameter("Comments");

		Long convertedName = Long.parseLong(name); // it is using in invalid mention using this line

		System.out.println(name);
		System.out.println(eMail);
		System.out.println(Mobile);
		System.out.println(Comments);

		PrintWriter writer = resp.getWriter();
		writer.print("<html>");
		writer.print("<body>");
		writer.print("<h1>");

		if (convertedName > 3) { // this is invalid mention condition method
			writer.print("<spam style= 'color : green'>");
			writer.print("Name is Valid Successfully");
		} else {
			writer.print("<spam style= 'color : yellow'>");
			writer.print("Name is Invalid");
		}
		writer.print("</spam>");
		writer.print("</h1>");
		writer.print("</body>");
		writer.print("</html>");

		resp.setContentType("text/html");

	}

}
