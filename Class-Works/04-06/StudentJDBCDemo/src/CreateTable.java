import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateTable {

	public static void main(String[] args) {
		
		String tname,c1,c2,c3;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter table name :");
		tname = s.next();
		System.out.println("Enter first col name :");
		c1 = s.next();
		System.out.println("Enter second col name :");
		c2 = s.next();
		System.out.println("Enter third col name :");
		c3 = s.next();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (Exception e) 
		{
			System.out.println("Error in loading drivers");
		}

		try 
		{
			String query="create table "+tname+"("+c1+" int primary key,"+c2+" varchar(20),"+c3+" numeric(8,2))";
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ips25java?user=root&password=root");
			PreparedStatement ps = con.prepareStatement(query);
			
			
			ps.executeUpdate();
			System.out.println("Table created successfully");
		} 
		catch (SQLException e) 
		{
			System.out.println("Error in sql statement:"+e);
			
		}
	}

}
