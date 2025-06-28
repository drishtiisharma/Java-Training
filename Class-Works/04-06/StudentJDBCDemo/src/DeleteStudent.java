import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteStudent {

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
			PreparedStatement ps = con.prepareStatement("delete from student "
			+ "where roll = ?");
			int r=0;
			Scanner s = new Scanner(System.in);
			int x=0;
				System.out.println("Enter rollno :");
				r = s.nextInt();
				ps.setInt(1, r);
				x = x + ps.executeUpdate();
			
			System.out.println(x+" record deleted successfully");
			con.close();
			ps.close();
		} 
		catch (SQLException e) 
		{
			System.out.println("Error in sql statement:"+e);
			
		}
	}

}
