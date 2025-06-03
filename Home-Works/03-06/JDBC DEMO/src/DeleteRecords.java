import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteRecords {

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
			int x=stmt.executeUpdate("delete from employee where empid=111");
			System.out.println(x+" records deleted from the table successfully");
			
			//step 5
			con.close();
			stmt.close();
			
		} catch (SQLException e) {
			System.err.println("Error in SQL Statement!");
	
		}

	}

}