package com.dataandtimeapi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.PreparableStatement;

public class DataTime {

	public static void main(String[] args) throws ParseException, Exception {
		Driver dr = new Driver();
		DriverManager.registerDriver(dr);
		String url = "jdbc:mysql://localhost:3306/ravi";
		String user = "root";
		String password = "root1234";
		Connection connect = DriverManager.getConnection(url, user, password);
	    

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name :: ");
		String name = sc.next();
		System.out.print("Enter the address ::");
		String address = sc.next();
		System.out.print("Enter the gender ::");
		String gender = sc.next();
		gender = gender.toUpperCase();
		System.out.print("Enter the dob (dd-MM-yyyy) ::");
		String dob = sc.next();
		System.out.println("Enter the date of joining(MM-dd-yyy) :: ");
		String doj = sc.next();
		System.out.println("Enter the date of marriage(yyyy-MM-dd) :: ");
		String dom = sc.next();
		
		String sqlquery = "insert into java values(?,?,?,?,?,?)";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date utildate = sdf.parse(dob);
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
		java.util.Date utildate1 = sdf1.parse(doj);
		
				
		long l = utildate.getTime();
		java.sql.Date sqldate = new java.sql.Date(l);
		long l1 = utildate1.getTime();
		java.sql.Date sqldate1 = new java.sql.Date(l1);
		java.sql.Date sqldate2 = java.sql.Date.valueOf(dom);	
		
		System.out.println(sqldate);
		System.out.println(sqldate1);
		PreparedStatement ps = connect.prepareStatement(sqlquery);
		ps.setString(1, name);
		ps.setString(2, address);
		ps.setString(3, gender);
		ps.setDate(4, sqldate);
		ps.setDate(5, sqldate1);
		ps.setDate(6, sqldate2);
		int rowseffected = ps.executeUpdate();

		System.out.println("no of rows effected ::" + rowseffected);

	}

}
