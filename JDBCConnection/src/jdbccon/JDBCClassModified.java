package jdbccon;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;
public class JDBCClassModified {

	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
			Class.forName("com.mysql.cj.jdbc.Driver"); // Method2: Registering the driver
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			Statement st=con.createStatement();
						
			//Insertion
			
			String query1="insert into empdetail(ename,edept,salary,hobby) values(?,?,?,?)";
			
			PreparedStatement pst=con.prepareStatement(query1);
			
			int rows_affected=st.executeUpdate(" insert into empdetail(ename,edept,salary,hobby,joinedon) values('Sharlyn','Dev',50000,'painting',now())");
			System.out.println("Query OK, "+rows_affected+" row affected");
		
			
			Scanner scanner=new Scanner(System.in);
			
			System.out.println("Enter the name:");
			String name=scanner.nextLine();
			System.out.println("Enter the dept :");
			String dept=scanner.nextLine();
			System.out.println("Enter the salary:");
			float salary=scanner.nextFloat();
			System.out.println("Enter the hobby:");
			String hobby=scanner.next();
			
			//System.out.println("Given values are"+name+dept+salary+hobby);
			
			pst.setString(1,name );
			pst.setString(2,dept);
			pst.setFloat(3,salary);
			pst.setString(4,hobby);
			
			int rows_affected_pst=pst.executeUpdate();
			
			System.out.println("Query OK, "+rows_affected_pst+" row affected");
			
			//Upadte statement    
			String query2="update empdetail set hobby=? where eid=?";
			pst=con.prepareStatement(query2);
			System.out.println("Enter the hobby");
			pst.setString(1,scanner.next() );
			System.out.println("Enter the ID of the employee whose hooby needs to be modified");
			pst.setInt(2,scanner.nextInt());
			int rows_updated=pst.executeUpdate();
			System.out.println("Query OK, "+rows_updated+" row updated by pst");
			
			//Selection
			ResultSet rs= st.executeQuery("select * from empdetail");
			System.out.println("EId\tEname\tDept\tsalary\thobby");
		while(rs.next()) {
				System.out.println(rs.getInt("eid")+"\t"+rs.getString("ename")+"\t"+rs.getString("edept")+"\t"+rs.getFloat("salary"));
		}	
			st.close();
			con.close();
			scanner.close();
		}
	}
