import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddStudents {

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
			PreparedStatement ps = con.prepareStatement("insert into student "
					+ "values(?,?,?)");
			int r=0;
			double m = 0;
			String n=null;
			Scanner s = new Scanner(System.in);
			int x=0;
			for(int i=1; i<=5; i++)
			{
				System.out.println("Enter rollno :");
				r = s.nextInt();
				System.out.println("Enter name :");
				n = s.next();
				System.out.println("Enter marks :");
				m = s.nextDouble();
				ps.setInt(1, r);
				ps.setString(2, n);
				ps.setDouble(3, m);
				x = x + ps.executeUpdate();
			}
			System.out.println(x+" record inserted successfully");
			con.close();
			ps.close();
		} 
		catch (SQLException e) 
		{
			System.out.println("Error in sql statement:"+e);
			
		}
	}

}
