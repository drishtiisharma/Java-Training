import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRecords {

	public static void main(String[] args) {
		
		//step 1
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			System.err.println("Error in loading drivers");
		}
		
		
		try {
			//step 2
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ips?user=root&password=root");
			
			//step 3
			Statement stmt=con.createStatement();
			
			//step 4
			int x=stmt.executeUpdate("insert into employee values(101,'rahul',23000,01)");
			x=x+stmt.executeUpdate("insert into employee values(102,'rita',12000,04)");
			x=x+stmt.executeUpdate("insert into employee values(103,'mehul',24000,05)");
			x=x+stmt.executeUpdate("insert into employee values(104,'ankit',65000,09)");
			x=x+stmt.executeUpdate("insert into employee values(105,'aniket',55000,02)");
			
			System.out.println(x+" records added in the table successfully");
			
			//step 5
			con.close();
			stmt.close();
			
		} catch (SQLException e) {
			System.err.println("Error in SQL Statement!");
	
		}

	}

}