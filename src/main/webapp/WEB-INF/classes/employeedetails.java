import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class employeedetails extends HttpServlet
{
	public void doGet(HttpServletRequest srq,HttpServletResponse srp) throws IOException,ServletException
	{
		PrintWriter out=srp.getWriter();
		String EMPID=srq.getParameter("EMPID");
		String EMPNAME=srq.getParameter("EMPNAME");
		String EMPDESIGN=srq.getParameter("EMPDESIGN");
		String EMPSSN=srq.getParameter("EMPSSN");
		String EMPCONTACT=srq.getParameter("EMPCONTACT");
		String EMPSAL=srq.getParameter("EMPSAL");
		String USERID=srq.getParameter("USERID");
		String PASSWORD=srq.getParameter("PASSWORD");

		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:wsm","","");

		PreparedStatement ps=con.prepareStatement("insert into  Employee  values(?,?,?,?,?,?,?,?);");
		ps.setString(1,EMPID); ps.setString(2,EMPNAME); ps.setString(3,EMPDESIGN); ps.setString(4,EMPSSN);
ps.setString(5,EMPCONTACT); ps.setString(6,EMPSAL); ps.setString(7,USERID); ps.setString(8,PASSWORD);
	int n = ps.executeUpdate();
		
		if(n==1)
		{
		out.println("<html>");
		out.println("<body background=bg.gif>");
		out.println("<center><b>updation is completed !!<b></center>");
		out.println("<a href=home.html>HOME</a></center>");
		}
		else
		{
		out.println("<html>");
		out.println("<body>");
		out.println("<center><b> UPDATION IS FAILED !!<b></center>");
		out.println("<a href=home.html>HOME</a></center>");
		}

		}
		
		catch(Exception e)
		{
			out.println("Exception caught : " +e);
		}

	}
}


		
		

