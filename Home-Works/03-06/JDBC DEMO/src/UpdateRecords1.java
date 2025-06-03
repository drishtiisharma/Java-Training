import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateRecords1 {

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
			PreparedStatement ps=con.prepareStatement("update employee set empname=? ,salary=?, deptno=? where empid=?");

			Scanner sc=new Scanner(System.in);
			System.out.println("enter how many records u want to update: ");
			int n=sc.nextInt();
			System.out.println();
			int x=0;
			String empname;
			double salary=0;
			int deptno=0;
			int empid=0;
			for(int i=1;i<=n;i++) {
				System.out.println("enter employee name to be updated: ");
				empname=sc.next();

				System.out.println("enter employee salary to be updated: ");
				salary=sc.nextDouble();

				System.out.println("enter employee dept no to be updated: ");
				deptno=sc.nextInt();
				
				System.out.println("enter employee id who's details need to be updated: ");
				empid=sc.nextInt();
				
				System.out.println();

				ps.setString(1, empname);
				ps.setDouble(2, salary);
				ps.setInt(3, deptno);
				ps.setInt(4, empid);

				//step 4
				x=x+ps.executeUpdate();
			}

			System.out.println(x+" records updated in the table successfully");

			//step 5
			con.close();
			ps.close();

		} catch (SQLException e) {
			System.err.println("Error in SQL Statement!");

		}

	}

}