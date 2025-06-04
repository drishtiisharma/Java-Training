import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetAllStudent {

	public static void main(String[] args) {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (Exception e) 
		{
			System.out.println("Error in loading drivers");
		}

		try 
		{
	
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ips25java?user=root&password=root");
			PreparedStatement ps = 
					con.prepareStatement("select * from student");
			
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					System.out.println("Rollno : "+rs.getInt("roll"));
					System.out.println("Name : "+rs.getString("name"));
					System.out.println("Marks : "+rs.getDouble("marks"));
				}
				
			
			con.close();
			ps.close();
		} 
		catch (SQLException e) 
		{
			System.out.println("Error in sql statement:"+e);
			
		}
	}

}
