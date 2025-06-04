import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class MataDataDemo {

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
			
			ResultSetMetaData md = rs.getMetaData();
			System.out.println("Table Name : "+md.getTableName(1));
			System.out.println("md.getColumnCount():"+md.getColumnCount());
			
			System.out.println("md.getColumnLabel(1):"+md.getColumnLabel(1));
			System.out.println("md.getColumnLabel(2):"+md.getColumnLabel(2));
			System.out.println("md.getColumnLabel(3):"+md.getColumnLabel(3));
			
			System.out.println("md.getColumnTypeName(1) :"+md.getColumnTypeName(1));
			System.out.println("md.getColumnTypeName(2) :"+md.getColumnTypeName(2));
			System.out.println("md.getColumnTypeName(3) :"+md.getColumnTypeName(3));
			
			
			con.close();
			ps.close();
		} 
		catch (SQLException e) 
		{
			
			
			System.out.println("Error in sql statement:"+e);
			
		}
	}

}
