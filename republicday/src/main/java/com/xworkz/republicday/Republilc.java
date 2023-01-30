package com.xworkz.republicday;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 1, urlPatterns = "/Servlet")
public class Republilc extends HttpServlet {

	public Republilc() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Running in Republic project");

		String name = req.getParameter("fightername");
		String alive = req.getParameter("alive");
		String mode = req.getParameter("mode");
		String weapon = req.getParameter("Ak 47");

		System.out.println(name);
		System.out.println(alive);
		System.out.println(mode);
		System.out.println(weapon);

		PrintWriter write = resp.getWriter();
		write.print("<html>");
		write.print("<body>");
		write.print("<h1>");
		write.print("<spam style= 'color:blue'>");
		write.print("print writter NAME =" + name + " " + "It is Print Successfully");
		/*
		 * System.out.println(); write.print("print writter ALIVE =" + alive + " " +
		 * "It is Print Successfully"); System.out.println();
		 * write.print("print writter MODE =" + mode + " " +
		 * "It is Print Successfully"); System.out.println();
		 * write.print("print writter WEAPON =" + weapon + " " +
		 * "It is Print Successfully");
		 */
		write.print("</spam>");
		write.print("</h1>");
		write.print("</body>");
		write.print("</html>");

		resp.setContentType("text/html");
	}

}
