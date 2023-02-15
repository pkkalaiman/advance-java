package com.xworkz.infosys;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 5, urlPatterns = "/Infosys")
public class Infosys extends HttpServlet {

	public Infosys() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Running to the Infosys Data...........");

		String name = req.getParameter("NameOf Company");
		String StartingDate = req.getParameter("StartingDate");
		String Address = req.getParameter("Address");
		String FloatNumer = req.getParameter("Float No");
		String MailId = req.getParameter("MailId");
		String MobilNumber = req.getParameter("Mobil No");
		String FaxNo = req.getParameter("FaxNo");
		String City = req.getParameter("City");
		String NoOfEmploye = req.getParameter("NoOfEmploye");
		String SubBrances = req.getParameter("SubBrance");
		String Logose = req.getParameter("Logose");
		String empSalary = req.getParameter("EmpSalary");
		String BrandValue = req.getParameter("Brand");
		String YearlyTurnOver = req.getParameter("YearlyTurOver");
		String noOfHR = req.getParameter("HR");
		String noOfCEO = req.getParameter("CEO");
		String howManyCountry = req.getParameter("Countries");
		String noOfShers = req.getParameter("Shers");
		String Market = req.getParameter("Market");
		String Bloomberg = req.getParameter("Bloomberg Code");

		System.out.println(name);
		System.out.println(StartingDate);
		System.out.println(Address);
		System.out.println(FloatNumer);
		System.out.println(MailId);
		System.out.println(MobilNumber);
		System.out.println(FaxNo);
		System.out.println(City);
		System.out.println(NoOfEmploye);
		System.out.println(SubBrances);
		System.out.println(Logose);
		System.out.println(empSalary);
		System.out.println(BrandValue);
		System.out.println(YearlyTurnOver);
		System.out.println(noOfHR);
		System.out.println(noOfCEO);
		System.out.println(howManyCountry);
		System.out.println(noOfShers);
		System.out.println(Market);
		System.out.println(Bloomberg);

		PrintWriter writer = resp.getWriter();
		writer.print("<html>");
		writer.print("<body>");
		writer.print("<h1>");
		writer.print("<spam style= 'color : green'>");
		writer.print("Name Created :"+name +" "+ "Printing Successfully......");
		writer.print("</spam>");
		writer.print("</h1>");
		writer.print("</body>");
		writer.print("</html>");
		
		resp.setContentType("text/html");

	}

}
