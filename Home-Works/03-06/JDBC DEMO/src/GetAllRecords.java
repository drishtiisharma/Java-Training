import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetAllRecords {

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
			ResultSet rs=stmt.executeQuery("select * from employee");
			while(rs.next()==true) {
				System.out.println("empid: "+rs.getInt("empid"));
				System.out.println("empname: "+rs.getString("empname"));
				System.out.println("salary: "+rs.getDouble("salary"));
				System.out.println("deptno: "+rs.getInt("deptno"));
				System.out.println();
			}
			
			
			//step 5
			con.close();
			stmt.close();
			
		} catch (SQLException e) {
			System.err.println("Error in SQL Statement!");
	
		}

	}

}