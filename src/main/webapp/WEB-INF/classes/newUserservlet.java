import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class newUserservlet extends HttpServlet
{
	public void doGet(HttpServletRequest srq,HttpServletResponse srp) throws IOException,ServletException
	{
		PrintWriter out=srp.getWriter();
		
		String PW=srq.getParameter("pw");
		String UN=srq.getParameter("se");
		String DESG=srq.getParameter("desg");
		String user,pass,desg;
                                    
		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:wsm","","");

		PreparedStatement ps=con.prepareStatement("insert into wsmlogin values(?,?,?);");
		ps.setString(1,UN);ps.setString(2,PW);ps.setString(3,DESG);
		int n = ps.executeUpdate();
		
		if(n==1)
		{
		out.println("<html>");
		out.println("<body background=bg.jpg>");
		out.println("<center><b>UserLogin is Created !!<b></center>");
		out.println("<a href=userlogin.html>UserLogin</a></center>");
		}
		else
		{
		out.println("<html>");
		out.println("<body>");
		out.println("<center><b>User Creation Failed !!<b></center>");
		out.println("<a href=userlogin.html>Relogin</a></center>");
		}

		}
		
		catch(Exception e)
		{
			out.println("Exception caught : " +e);
		}

	}
}
