package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class application
 */
@WebServlet("/application")
public class application extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public application() {
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
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String fname=request.getParameter("firstname");
		String lname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String age=request.getParameter("age");
		String gen=request.getParameter("gender");
		String skills=request.getParameter("softskills");
		String depart=request.getParameter("department");
		String ten=request.getParameter("tenth");
		String twel=request.getParameter("twelth");
		String ug=request.getParameter("ug");
		String date=request.getParameter("date-of-birth");
		String addres=request.getParameter("add");
	applicationDao.validate(fname,lname,email,age,gen,skills,depart,ten,twel,ug,date,addres);
		
		RequestDispatcher rd=request.getRequestDispatcher("successfull.html");
		rd.include(request, response);
	}
	
	}


