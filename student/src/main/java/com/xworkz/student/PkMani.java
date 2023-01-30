package com.xworkz.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 1, urlPatterns = "/pkmani")
public class PkMani extends HttpServlet {

	public PkMani() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Running in Init Method P K Mani Servlet.......");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Running  doPost in P K Mani Servlet...........");

		String name = req.getParameter("Name");
		String id = req.getParameter("IdCard");
		String deportment = req.getParameter("Depportment");
		String subjectName = req.getParameter("SubjectName");
		String dateOfTest = req.getParameter("DateOfTest");
		String mobileNo = req.getParameter("MobileNo");

		System.out.println(name);
		System.out.println(id);
		System.out.println(deportment);
		System.out.println(subjectName);
		System.out.println(dateOfTest);
		System.out.println(mobileNo);

		PrintWriter writ = resp.getWriter();

		writ.print("<html>");
		writ.print("<body>");
		writ.print("<h1>");

		if (name.length() > 5 && id.length() > 9 && deportment.length() > 9 && subjectName.length() > 9
				&& dateOfTest.length() > 10 && mobileNo.length() > 10) {
			
			writ.print("<spam style='color : blue'>");
			writ.print("Submit Successfully......");
			writ.print("</spam>");

		}else {
			writ.print("<spam style='color : red'>");
			writ.print("Please Enter Valide Data!!!!!....");
			writ.print("</spam>");
		}
		
		writ.print("</h1>");
		writ.print("<a href=\"index.html\">Home Page</a>");
		writ.print("<br>");
		writ.print("<a href=\"mani.html\">Submit Again</a>");
		writ.print("</body>");
		writ.print("</html>");
		
		resp.setContentType("text/html");
	}

}
