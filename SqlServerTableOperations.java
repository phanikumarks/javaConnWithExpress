package Tableoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlServerTableOperations {

	public static void main(String[] args) throws SQLException {
		
		        // Creating connection with the database
				Connection conn = DriverManager.getConnection("jdbc:sqlserver://0.0.0.0;encrypt=false;"
						+ "databaseName=student_database", "admin", "password");
				
				// Creating a statement object
				Statement st = conn.createStatement();
				
				// Inserting the data into the table
				int insertStatement = st.executeUpdate(("insert into students values(1, 'Mahesh', 25, 'Male')")
				+("insert into students values(2, 'Suresh', 24, 'Male')")
				+("insert into students values(3, 'Neelima', 24, 'Female')")
				+("insert into students values(4, 'Raju', 24, 'Male')")
				+("insert into students values(5, 'Mamatha', 26, 'Female')")
				+("insert into students values(6, 'Mohan', 23, 'Male')")
				+("insert into students values(7, 'Laxmi', 26, 'Female')"));
				System.out.println("inserStatement executed:"+insertStatement);
				
				// deleting the row in the table
				int deleteStatement = st.executeUpdate("delete from students where student_id = 7");
				System.out.println("Deletestatement executed:"+deleteStatement);
				
				// selecting all the rows in the table
				ResultSet rs = st.executeQuery("select * from students");
				System.out.println("Student_id\tStudent_name\tAge\t\tGender");
				while(rs.next()) {
					int student_id = rs.getInt("student_id");
					String student_name = rs.getString("student_name");
					int age = rs.getInt("age");
					String gender = rs.getString("gender");
					System.out.println(student_id +"\t\t" + student_name + "\t\t" + age + "\t\t" + gender);
				}
				
				// Closing the connection with database
				conn.close();				
			
				}
			
	}


