package jdbc_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Postgres_conn {

	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/practice","postgres","password");
		Statement stmt = conn.createStatement();
//		String q = "Delete from car_travels where cars='Car4'";
//		stmt.execute(q);
		String q = "Select * from car_travels";
		ResultSet rs = stmt.executeQuery(q);
		while(rs.next()) {
			System.out.println(rs.getString(1)+"     "+rs.getString(2)+"     "+rs.getString(3));
		}
		conn.close();
		System.out.println("Query executed");
	}	
}
