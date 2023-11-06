package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



/**
 * Servlet implementation class loginDao
 */
public class loginDao {
	
	public static boolean validate(String name,String pass) {
		boolean status=false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/java","root","1234567890");
			PreparedStatement ps=con.prepareStatement("select * from first where username=? and password=?");
			ps.setString(1,name);
			ps.setString(2,pass);
			
			ResultSet rs=ps.executeQuery();
			status=rs.next();
		}catch(Exception e) {
			System.out.println(e);
			}return status;
	}
}
