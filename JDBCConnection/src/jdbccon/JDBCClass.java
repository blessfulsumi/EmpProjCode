package jdbccon;

import java.sql.*;
import java.text.SimpleDateFormat;

public class JDBCClass {

	public static void main(String[] args) throws SQLException {

		String url="jdbc:mysql://localhost:3306/employee";
		String username="root";
		String password="root";
		String query="select * from empdetail";

		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection con=DriverManager.getConnection(url, username, password);

		Statement st=con.createStatement();
		ResultSet rs= st.executeQuery(query);



		//single element
		/*-------------------------------------------------
 		rs.next();
		System.out.println(rs.getString("ename"));
		----------------------------------------------------*/


		//for a set of values
		String name;
		int id;
		Timestamp d;
		while(rs.next()) {
			name=rs.getString("ename");
			id=rs.getInt("eid");
			d=rs.getTimestamp(6);

			//System.out.println(rs.getString("ename")+rs.getString("eid"));
			System.out.println(id+"   "+name+"   "+d);
		}	
		st.close();
		con.close();
	}
}
