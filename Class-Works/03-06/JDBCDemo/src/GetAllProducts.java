import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetAllProducts {

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
			ResultSet rs = stmt.executeQuery("select * from product");
			
			while(rs.next())
			{
				System.out.println("P-Id : "+rs.getInt("pid"));
				System.out.println("P-Name : "+rs.getString("pname"));
				System.out.println("Price : "+rs.getDouble("price"));
				
			}
			
			
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
