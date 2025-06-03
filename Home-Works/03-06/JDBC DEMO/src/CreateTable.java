import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

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
			Statement stmt=con.createStatement();
			
			//step 4
			stmt.executeUpdate("create table employee "
					+ "(empid int primary key, "
					+ "empname varchar(20) not null,"
					+ "salary numeric(8,2),"
					+ "deptno int not null)");
			System.out.println("table created successfully");
			
			//step 5
			con.close();
			stmt.close();
			
		} catch (SQLException e) {
			System.err.println("Error in SQL Statement!");
	
		}

	}

}