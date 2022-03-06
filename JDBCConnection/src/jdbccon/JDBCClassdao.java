package jdbccon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCClassdao {
	public static PreparedStatement pst;
	public static Scanner scanner;
	String name;
	String dept;
	float salary;
	String hobby;
	
	public void insert() throws SQLException
	 {
		scanner=new Scanner(System.in);	
		
		System.out.println("Enter name,dept,salary & hobby");
		pst.setString(1,scanner.nextLine() );
		pst.setString(2,scanner.nextLine());
		pst.setFloat(3,scanner.nextFloat());
		pst.setString(4,scanner.next());
	 }

	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver"); // Method2: Registering the driver
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
		Statement st=con.createStatement();
		JDBCClassdao daoobj=new JDBCClassdao();			
		
		//insert statement   new Date()   LocalDateTime.now()
		String query1="insert into empdetail(ename,edept,salary,hobby) values(?,?,?,?)";
		pst=con.prepareStatement(query1);
		daoobj.insert();
		int rows_affected_pst=pst.executeUpdate();
		System.out.println("Query OK, "+rows_affected_pst+" row inserted by pst");
		
		
		//Update statement    
		scanner=new Scanner(System.in);	
		String query2="update empdetail set hobby=? where eid=?";
		pst=con.prepareStatement(query2);
		pst.setString(1,scanner.next() );
		pst.setInt(2,scanner.nextInt());
		int rows_updated=pst.executeUpdate();
		System.out.println("Query OK, "+rows_updated+" row updated by pst");
		
		
		//delete statement
		String query3="delete from empdetail where eid=?";
		pst=con.prepareStatement(query3);
		System.out.println("Enter the eid of an employee to be removed:");
		pst.setInt(1,scanner.nextInt());
		int rows_deleted=pst.executeUpdate();
		System.out.println("Query OK, "+rows_deleted+" row deleted by pst");
		
			
		st.close();
		con.close();
	}

}










//		pst=con.prepareStatement(query1);
//		pst.setString(1,daoobj.name );
//		pst.setString(2,daoobj.dept);
//		pst.setFloat(3,daoobj.salary);
//		pst.setString(4,daoobj.hobby);
		
//		daoobj.Directinsert();
//		Scanner scanner=new Scanner(System.in);	
//		
//		pst=con.prepareStatement(query1);
//		pst.setString(1,scanner.nextLine() );
//		pst.setString(2,scanner.nextLine());
//		pst.setFloat(3,scanner.nextFloat());
//		pst.setString(4,scanner.next());
//		
		
	
		
		
//		int rows_affected=st.executeUpdate(" insert into empdetail(ename,edept,salary,hobby,joinedon) values('Sharlyn','Dev',50000,'painting',now())");
//		System.out.println("Query OK, "+rows_affected+" row affected");
//		
//		ResultSet rs= st.executeQuery("select * from empdetail");
//	while(rs.next()) {
//			System.out.println(rs.getInt("eid")+"   "+rs.getString("ename")+"   "+rs.getString("edept")+"     "+rs.getFloat("salary"));
//	}	
//		st.close();
//		con.close();
//	}
//
//}
