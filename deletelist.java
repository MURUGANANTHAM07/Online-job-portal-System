package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deletelist
 */
@WebServlet("/deletelist")
public class deletelist extends HttpServlet {
	private static final String query="SELECT * FROM job";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletelist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/jobportal","root","1234567890");
			
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			out.println("<table  border='5' height='40' >");
			out.print("<tr>");
			out.print("<th>id</th>");
			out.print("<th>FIRSTNAME</th>");
			out.print("<th>LASTNAME</th>");
			out.print("<th>EMAIL</th>");
			out.print("<th>AGE</th>");
			out.print("<th>GENDER</th>");
			out.print("<th>SOFTSKILLS</th>");
			out.print("<th>DEPARTMENT</th>");
			out.println("<th>TENTHPERCENTAG</th>");
			out.println("<th>TWELTHPERCENTAGE</th>");
			out.println("<th>UGPERCENTAGE</th>");
			out.println("<th>DATEOFBIRTH</th>");
			out.println("<th>ADDRESS</th>");
			out.print("<th>delete</th>");
			
			
			out.print("</tr>");
		
		
			while (rs.next())
			{
				out.print("<tr>");
				out.print("<td>" +rs.getString("id")+"</td>");
				out.print("<td>" +rs.getString("FIRSTNAME")+"</td>");
				out.print("<td>" +rs.getString("LASTNAME")+"</td>");
				out.print("<td>" +rs.getString("EMAIL")+"</td>");
				out.print("<td>" +rs.getString("AGE")+"</td>");
				out.print("<td>" +rs.getString("GENDER")+"</td>");
				out.print("<td>" +rs.getString("SOFTSKILLS")+"</td>");
				out.print("<td>" +rs.getString("DEPARTMENT")+"</td>");
				out.print("<td>" +rs.getString("TENTHPERCENTAGE")+"</td>");
				out.print("<td>" +rs.getString("TWELTHPERCENTAGE")+"</td>");
				out.print("<td>" +rs.getString("UGPERCENTAGE")+"</td>");
				out.print("<td>" +rs.getString("DATEOFBIRTH")+"</td>");
				out.print("<td>" +rs.getString("ADDRESS")+"</td>");
				out.print("<td><a href='deletee?id="+rs.getInt("id")+"'>delete</a></td>");
				
		
				
				out.print("</tr>");
				
			}
			out.println("</table>");
		
	
		}catch(SQLException e) {
			e.printStackTrace();
			out.println("<h1>"+e.getMessage()+"</h1>");
		}catch(Exception ex) {
			ex.printStackTrace();
			out.println("<h1>"+ex.getMessage()+"</h1>");
		}
		
		out.println("Below 60% candidate not eligible for recruitment process.");
		
		
		out.println("<a href='project.html'>JOBPORTAL</a>");

	}

	
}
