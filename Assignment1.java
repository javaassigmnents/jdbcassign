package com.ineuron.of;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;



public class Assignment1 {

	public static void main(String[] args) throws SQLException {
		PreparedStatement ps = null;
		Driver dr = new Driver();
		DriverManager.registerDriver(dr);
		String url = "jdbc:mysql://localhost:3306/ravi";
		String user = "root";
		String password = "root1234";
		Connection connect = DriverManager.getConnection(url, user, password);
		System.out.println("CRUD operations ::");
		System.out.println("1->Create");
		System.out.println("2->Read");
		System.out.println("3->Update");
		System.out.println("4->Delete");
		Scanner sc = new Scanner(System.in);
		System.out.print("Select any of the operations mentioned above ::");
		int i = sc.nextInt();
		if (i == 1) {
			String query = "create table firstclass(name varchar(20) ,age int)";
			if (connect != null)
				ps = connect.prepareStatement(query);
			ps.executeUpdate();

		}
		if (i == 2) {
			String query = "select * from firstclass";
			ps=connect.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				System.out.println("\tName\tAge");
				while (rs.next()) {

					String name = rs.getString(1);
					int age = rs.getInt(2);
					System.out.println("\t" + name + "\t" + age);

				}
			}
		}
		if(i==3) {
			String query = "insert into firstclass values(?,?)";
			ps =connect.prepareStatement(query);
			if(ps!=null) {
				ps.setString(1, "raj");
				ps.setInt(2, 27);
				int norowseffected =ps.executeUpdate();
				System.out.println("no rows beffected is ::"+norowseffected);
				
			}
		}
		if(i==4) {
			String query ="delete from firstclass where name =?";
			ps = connect.prepareStatement(query);
			if(ps!=null) {
				ps.setString(1, "ravi");
				int noofrowsdeleted =ps.executeUpdate();
				System.out.println("no  of rows deleted :: "+noofrowsdeleted);
			}
		}
			

	}

}
