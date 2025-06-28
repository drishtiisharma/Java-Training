import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateRecords {

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
			int x=stmt.executeUpdate("update employee set empname='shyam', salary=42000, deptno=06 where empid=104");
			x=x+stmt.executeUpdate("update employee set empname='ram', salary=40000, deptno=06 where empid=105");

			
			System.out.println(x+" records updated in the table successfully");
			
			//step 5
			con.close();
			stmt.close();
			
		} catch (SQLException e) {
			System.err.println("Error in SQL Statement!");
	
		}

	}

}