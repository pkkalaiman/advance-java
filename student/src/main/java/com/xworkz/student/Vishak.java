package com.xworkz.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 2, urlPatterns = "/vishak")
public class Vishak extends HttpServlet {

	public Vishak() {
		System.out.println("Created : " + this.getClass().getSimpleName());
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Running Init Vishak Servlet.......");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Running in doPost Method Vishak Servlet............");

		String name = req.getParameter("Name");
		String id = req.getParameter("Id");
		String Deportment = req.getParameter("Deportment");
		String SubjectName = req.getParameter("SubjectName");
		String DateOfTest = req.getParameter("DateOfTest");
		String MobileNo = req.getParameter("MobileNo");

		System.out.println(name);
		System.out.println(id);
		System.out.println(Deportment);
		System.out.println(SubjectName);
		System.out.println(DateOfTest);
		System.out.println(MobileNo);

		PrintWriter writer = resp.getWriter();

		writer.print("<html>");
		writer.print("<body>");
		writer.print("<h1>");

		if (name.length() > 5 && id.length() > 10 && Deportment.length() > 8 && SubjectName.length() > 8
				&& DateOfTest.length() > 5 && MobileNo.length() > 10) {

			writer.print("<spam style='color :blue'>");
			writer.print("Submited Successfully!!!!!!!");
			writer.print("</spam>");

		} else {
			writer.print("<spam style='color : red'>");
			writer.print("Please Enter Valid Information...??");
			writer.print("</spam>");
		}

		writer.print("</h1>");
		writer.print("<a href=\"index.html\">Home Page</a>");
		writer.print("<br>");
		writer.print("<a href=\"vishak.html\">Submit Again</a>");
		writer.print("</body>");
		writer.print("</html>");

		resp.setContentType("text/html");

	}

}
