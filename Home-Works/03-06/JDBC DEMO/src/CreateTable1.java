import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateTable1 {

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
			PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?)");
			
			
			Scanner sc=new Scanner(System.in);
			int empid=0;
			String empname;
			double salary=0;
			int deptno=0;
			int x=0;
			for(int i=1;i<=5;i++) {
				System.out.println("enter employee id: ");
				empid=sc.nextInt();
				System.out.println("enter employee name: ");
				empname=sc.next();
				System.out.println("enter employee salary: ");
				salary=sc.nextDouble();
				System.out.println("enter employee deptno: ");
				deptno=sc.nextInt();
				
				System.out.println();
				ps.setInt(1, empid);
				ps.setString(2, empname);
				ps.setDouble(3, salary);
				ps.setInt(4, deptno);
				//step 4
				x=x+ps.executeUpdate();
				
				
			}
			System.out.println(x+" records inserted successfully in the table");
			
			
			//step 5
			con.close();
			ps.close();
			
		} catch (SQLException e) {
			System.err.println("Error in SQL Statement!");
	
		}

	}

}