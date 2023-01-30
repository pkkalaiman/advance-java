package com.xworkz.webseries;

import java.awt.image.ConvolveOp;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 3, urlPatterns = "/Mobile")
public class FreeMobileServlet extends HttpServlet {



	public FreeMobileServlet() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Running in Init Servlet..........");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Running in doGet FreeMobile Servlet..............");

		String name = req.getParameter("MobileName");
		String Email = req.getParameter("Email");
		String password = req.getParameter("userPassword");
		String confirPassword = req.getParameter("confirmPassword");
		String MobilNo = req.getParameter("MobilNo");
		
		Long convertedmobile=Long.parseLong(MobilNo);
	//	Long convertedPassword=Long.parseLong(password);

		System.out.println(name);
		System.out.println(Email);
		System.out.println(password);
		System.out.println(confirPassword);
		System.out.println(MobilNo);

		PrintWriter writer = resp.getWriter();
		writer.print("<html>");
		writer.print("<body>");
		writer.print("<h1>");
		
		/*
		 * if(convertedPassword >10) { writer.print("<spam style= 'color :green'>");
		 * writer.print("Password  is Valid");
		 * 
		 * }else { writer.print("<spam style= 'color :red'>");
		 * writer.print("Password is Invalid :");
		 * 
		 * }
		 */
		

		if(convertedmobile >0) {
		writer.print("<spam style= 'color :green'>");
		writer.print("Mobile No is Valid");
		
		}else {
			writer.print("<spam style= 'color :red'>");
			writer.print("Mobile No Invalid :");
			
		}
		
		//writer.print("Mobile No :"+name+" "+"Printing Successfully");
		writer.print("</spam>");
		writer.print("</h1>");
		writer.print("</body>");
		writer.print("<html>");
		

		resp.setContentType("text/html");

	}

}
