import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GetAllRecords1 {

	public static void main(String[] args) {

		//step 1
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			System.err.println("Error in loading drivers");
		}


		try {
			//step 2
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ips?user=root&password=root");

			//step 3
			PreparedStatement ps=con.prepareStatement("select * from employee");

			//step 4
			ResultSet rs= ps.executeQuery();
			while(rs.next()==true) {
				System.out.println("employee id: "+rs.getInt("empid"));
				System.out.println("employee name: "+rs.getString("empname"));
				System.out.println("employee salary: "+rs.getDouble("salary"));
				System.out.println("employee dept no: "+rs.getInt("deptno"));
				System.out.println();
			}

			//step 5
			con.close();
			ps.close();

		} catch (SQLException e) {
			System.err.println("Error in SQL Statement!");

		}

	}

}