import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteRecords1 {

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
			PreparedStatement ps=con.prepareStatement("delete from employee where empid=?");

			Scanner sc=new Scanner(System.in);
			System.out.println("enter how many records u want to delete: ");
			int n=sc.nextInt();
			System.out.println();
			int x=0;
			int empid=0;
			for(int i=1;i<=n;i++) {
				System.out.println("enter employee id of the associated emp record to be deleted: ");
				empid=sc.nextInt();
				System.out.println();
				ps.setInt(1, empid);

				//step 4
				x=x+ps.executeUpdate();
			}

			System.out.println(x+" records deleted from the table successfully");

			//step 5
			con.close();
			ps.close();

		} catch (SQLException e) {
			System.err.println("Error in SQL Statement!");

		}

	}

}