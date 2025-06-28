import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddProduct2 {

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
			PreparedStatement ps = 
				con.prepareStatement("insert into product values(?,?,?)");
			Scanner s = new Scanner(System.in);
			int id = 0;
			double price = 0;
			String pname;
			int x=0;
			for(int i=1; i<=3; i++)
			{
				System.out.println("Enter Product Id : ");
				id = s.nextInt();
				System.out.println("Enter Product Name : ");
				pname = s.next() ;
				System.out.println("Enter Price : ");
				price = s.nextDouble();
				ps.setInt(1, id);
				ps.setString(2, pname);
				ps.setDouble(3, price);
				//step 4
				x = x + ps.executeUpdate();
			}
			System.out.println(x+" Record Inserted Successfully");
			
			//step 5
			con.close();
			ps.close();
			
		}
		catch (SQLException e) 
		{
			System.out.println("Error in sql statement");
		}
	}

}
