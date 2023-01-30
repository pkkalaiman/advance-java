package com.xworkz.serverproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 1, urlPatterns = "/Hospital")
public class HospitalServer extends HttpServlet {

	public HospitalServer() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Running in Do Get HospitalServlet .......");

	}
/**************************************************************************************************************************/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Running in DO POST methos in Hospital.............");
		String data = "THE DO POST METHOD IS  // HOSPITAL MANAGNMENT // TODAY PROJECT // WILL GET PROCED";
		
		PrintWriter writ = resp.getWriter();

		writ.print(data);
		resp.setContentType("text/plain");

	}
/******************************************************************************************************************/

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Running in Do Put methos on HospitalServer.....");

		/*
		 * String data = "DO PUT Method in Hospital // Patient // NAME // Vishak";
		 * 
		 * PrintWriter print = resp.getWriter();
		 * 
		 * print.print(data);
		 * 
		 * resp.setContentType("text/plain");
		 */
	}
/***************************************************************************************************************/
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Running in Do Delete methos on HospitalServer.....");

		/*
		 * String data = "DO PUT in Hospital // Docters // NAME // P K Mani";
		 * PrintWriter print = resp.getWriter();
		 * 
		 * print.print(data); resp.setContentType("text/plain");
		 */
	}
	/*********************************************************************************************************/

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Running in Do Opstion methos on HospitalServer.....");

		/*
		 * String data = "DO PUT in Hospital // NURSE // hou many  // 36764";
		 * PrintWriter print = resp.getWriter(); print.print(data);
		 * 
		 * resp.setContentType("text/plain");
		 */
	}
/*************************************************************************************************************************/
	@Override
	protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Running in Do Head methos on HospitalServer.....");

		/*
		 * String data = "DO PUT in Hospital // Out Patients // hou many  // 9785";
		 * 
		 * PrintWriter print = resp.getWriter();
		 * 
		 * print.print(data); resp.setContentType("text/plain");
		 */
	}
	
/*************************************************************************************************************************/
	@Override
	protected void doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Running in Do Trace methos on HospitalServer.....");

		/*
		 * String data =
		 * "DO PUT in Hospital // Hospital Name // Bharathi Hospital // Mani Hospital";
		 * 
		 * PrintWriter print = resp.getWriter(); print.print(data);
		 * 
		 * resp.setContentType("text/plain");
		 */
	}

}
