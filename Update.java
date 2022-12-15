package com.jdbc.ps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class Update {

	public static void main(String[] args) throws SQLException {
		Connection connect = null;
		PreparedStatement ps = null;
		Scanner sc = new Scanner(System.in);
		try {
			// Step1=Load and register the driver//
			Driver dr = new Driver();
			DriverManager.registerDriver(dr);
			String url = "jdbc:mysql://localhost:3306/ravi";

			String user = "root";
			String password = "root1234";
			System.out.println("Enter the user id :: ");
			int userid = sc.nextInt();

			System.out.println("Enter the username :: ");
			String username = sc.next();

			connect = DriverManager.getConnection(url, user, password);
			String query = "update users set username =? where  userid=?";
			if (connect != null) {
				ps = connect.prepareStatement(query);
				ps.setString(1, username);
				ps.setInt(2, userid);

				int norowseff = ps.executeUpdate();

				System.out.println("no of rows effected :: " + norowseff);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (Exception s) {
			s.printStackTrace();
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
