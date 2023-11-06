package demo;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registrationDao
 */
@WebServlet("/registrationDao")
public class registrationDao  {
	
	public static boolean validate(String username,String firstname,String lastname,String pass,String repass,String date,String add) {
		boolean status=false;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/java","root","1234567890");
		PreparedStatement ps=con.prepareStatement("insert into first (username,firstname,lastname,password,retypepassword,birthdate,address)values(?,?,?,?,?,?,?)");
				
		ps.setString(1,username);
		ps.setString(2,firstname);
		ps.setString(3,lastname);
		ps.setString(4,pass);
		ps.setString(5,repass);
		ps.setString(6,date);
		ps.setString(7,add);
		 ps.executeUpdate();
	}catch(Exception e) {System.out.println(e);}
	return status;
}
       
    public registrationDao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
