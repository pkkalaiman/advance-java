package com.xworkz.mani;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCWorking {
	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // it is Loading And Registered Step

			// it will connection in DataBase Step       (    "url",                        "name", "Password")
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mani", "root", "Xworkz@123");

			// it is Create in Statement
			Statement stat = con.createStatement();
			System.out.println(con);

			// It is Insert in Query Values
			String insertQuery = "insert into project_table values(0,'mani','Kannyiram', 'Sandhiya','male','pkkalaiman@gmail.com');";

			// it is ExecuteUbdate the Query
			int statment = stat.executeUpdate(insertQuery);
			System.out.println(statment);

			// it will don't Close it Leaking in the "Persistence"
			con.close();

			// it will Avoiding to the ClassNotFoundException
		} catch (ClassNotFoundException exception) {
			System.out.println("Exception :" + exception.getMessage());

			// it will Avoiding to the SQLException
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	
}
