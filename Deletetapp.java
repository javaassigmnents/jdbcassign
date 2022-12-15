package com.jdbc.ps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class Deletetapp {
	public static void main(String[] args) throws SQLException {
		Driver dr = new Driver();
		DriverManager.registerDriver(dr);
		Connection connect = null;
		PreparedStatement ps = null;
		
		String url = "jdbc:mysql://localhost:3306/ravi";
		String user = "root";
		String password = "root1234";
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the sudent id ::");
		int sid1 = sc.nextInt();
		connect = DriverManager.getConnection(url, user, password);
		String sqlquery = "delete from student where sid =?";

		try {
			if (connect != null) {
				ps = connect.prepareStatement(sqlquery);
			}
			if (ps != null) {
				ps.setInt(1, sid1);
				int norowseffected = ps.executeUpdate();
				System.out.println("no of rows effected :: "+norowseffected);
			}
			
			
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connect != null) {
				connect.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (sc != null) {
				sc.close();
			}
		}

	}
}

