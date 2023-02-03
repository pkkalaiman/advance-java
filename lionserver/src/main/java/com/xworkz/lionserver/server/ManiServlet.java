package com.xworkz.lionserver.server;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManiServlet
 */
@WebServlet(loadOnStartup = 1,  urlPatterns = "/ManiServlet")
public class ManiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManiServlet() {
        super();
        System.out.println("Created : "+this.getClass().getSimpleName());
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Running in doPost in ManiServlet............");
		
		String fName=req.getParameter("fName");
		String lName=req.getParameter("lName");
		String gender=req.getParameter("Gender");
		String reason=req.getParameter("reason");
		String address=req.getParameter("address");
		
		
		System.out.println("fName: "+fName);
		System.out.println("lName: "+lName);
		System.out.println("Gender:"+gender);
		System.out.println("Reason: "+reason);
		System.out.println("Address: "+address);
		
		
		RequestDispatcher dispach= req.getRequestDispatcher("message.jsp");
		
		req.setAttribute("fName", fName);
		req.setAttribute("lName", lName);
		req.setAttribute("gender", gender);
		req.setAttribute("reason", reason);
		req.setAttribute("address", address);
	
		dispach.forward(req, resp);
		
		
	}

}
