package com.jdbc.ps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class Inserapp {

	public static void main(String[] args) throws SQLException {
		Connection connect = null;
		PreparedStatement ps = null;

		Driver dr = new Driver();
		DriverManager.registerDriver(dr);

		String url = "jdbc:mysql://localhost:3306/ravi";
		String user = "root";
		String password = "root1234";
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the userid :: ");
		int userid = sc.nextInt();
		System.out.print("Enter the username ::");
		String username = sc.next();

		connect = DriverManager.getConnection(url, user, password);
		String sqlquery = "insert into users values(?,?) ";
		try {
			if (connect != null) {
				ps = connect.prepareStatement(sqlquery);
			}
			if (ps != null) {
				ps.setInt(1, userid);
				ps.setString(2, username);
				int noRowseffected = ps.executeUpdate();

				System.out.println("no of rows effected :: " + noRowseffected);

			}
		} catch (SQLException e) {
			e.printStackTrace();
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