import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddProduct {

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
			int x = stmt.executeUpdate("insert into product values(101,'Keyboard',740)");
			x = x+stmt.executeUpdate("insert into product values(102,'Mouse',550)");
			x = x+stmt.executeUpdate("insert into product values(103,'Mic',2200)");
			x = x+stmt.executeUpdate("insert into product values(104,'RAM',1250)");
			x = x+stmt.executeUpdate("insert into product values(105,'Monitor',3400)");
			
			System.out.println(x+" Record Inserted Successfully");
			
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
