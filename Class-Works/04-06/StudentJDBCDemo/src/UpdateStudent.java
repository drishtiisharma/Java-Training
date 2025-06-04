import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateStudent {

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
			PreparedStatement ps = con.prepareStatement("update student "
			+ "set name = ?,marks = ? where roll = ?");
			int r=0;
			double m = 0;
			String n=null;
			Scanner s = new Scanner(System.in);
			int x=0;
				System.out.println("Enter rollno :");
				r = s.nextInt();
				System.out.println("Enter name :");
				n = s.next();
				System.out.println("Enter marks :");
				m = s.nextDouble();
				ps.setString(1, n);
				ps.setDouble(2, m);
				ps.setInt(3, r);
				x = x + ps.executeUpdate();
			
			System.out.println(x+" record updated successfully");
			con.close();
			ps.close();
		} 
		catch (SQLException e) 
		{
			System.out.println("Error in sql statement:"+e);
			
		}
	}

}
