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
 * Servlet implementation class applicationDao
 */
@WebServlet("/applicationDao")
public class applicationDao  {
	public static boolean validate(String firstname,String lastname,String mail,String age,String gender,String softskills,String department,String tenth,String twelth,String ug,String birthdate,String address) {
		boolean status=false;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/jobportal","root","1234567890");
		PreparedStatement ps=con.prepareStatement("insert into job (FIRSTNAME,LASTNAME,EMAIL,AGE,GENDER,SOFTSKILLS,DEPARTMENT,TENTHPERCENTAGE,TWELTHPERCENTAGE,UGPERCENTAGE,DATEOFBIRTH,ADDRESS)values(?,?,?,?,?,?,?,?,?,?,?,?)");
				
		ps.setString(1,firstname);
		ps.setString(2,lastname);
		ps.setString(3,mail);
		ps.setString(4,age);
		ps.setString(5,gender);
		ps.setString(6,softskills);
		ps.setString(7,department);
		ps.setString(8,tenth);
		ps.setString(9,twelth);
		ps.setString(10,ug);
		ps.setString(11,birthdate);
		ps.setString(12,address);
		
		 ps.executeUpdate();
	}catch(Exception e) {System.out.println(e);}
	return status;
}
    public applicationDao() {
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
