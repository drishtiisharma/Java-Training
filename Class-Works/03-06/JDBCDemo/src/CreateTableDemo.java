import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableDemo {

	public static void main(String[] args) {
		
		//step1
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e) 
		{
			System.out.println("Error in loading drivers");
		}

		try 
		{
			//step2
			Connection con = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/ips25java?"
					+ "user=root&password=root");
			
			//step3
			Statement stmt = con.createStatement();
			
			//step 4
			stmt.executeUpdate("create table product"
					+ "(pid int primary key,"
					+ "pname varchar(20),"
					+ "price numeric(8,2))");
			System.out.println("Table Created Successfully");
			
			//step 5
			con.close();
			stmt.close();
			
		}
		catch (SQLException e) 
		{
			System.out.println("Error in sql statement");
		}
	}

}
