package com.xworkz.messageserver;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MessageServer
 */
@WebServlet(loadOnStartup = 2, urlPatterns = "/MessageServer")
public class MessageServer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MessageServer() {
		super();
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Running in doPost Method in MessageServer..........");

		String fName = req.getParameter("fName");
		String lName = req.getParameter("lName");
		String gender = req.getParameter("Gender");
		String reason = req.getParameter("reason");
		String address = req.getParameter("address");

		System.out.println(fName);
		System.out.println(lName);
		System.out.println(gender);
		System.out.println(reason);
		System.out.println(address);

		RequestDispatcher dispacher = req.getRequestDispatcher("servermessage.jsp");

		req.setAttribute("fName", fName);
		req.setAttribute("lName", lName);
		req.setAttribute("gender", gender);
		req.setAttribute("reason", reason);
		req.setAttribute("address", address);

		dispacher.forward(req, resp);

	}

}
