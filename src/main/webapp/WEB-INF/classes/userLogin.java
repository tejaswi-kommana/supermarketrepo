import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class userLogin extends HttpServlet
{
	public void doGet(HttpServletRequest srq,HttpServletResponse srp) throws IOException,ServletException
	{
		PrintWriter out=srp.getWriter();
		
		String PW=srq.getParameter("pw");
		String UN=srq.getParameter("se");
		String DESG=srq.getParameter("desg");
		String user,pass,desg;
                           	int flag=0;

		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:wsm","","");

		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select *  from wsmlogin ");
		while(rs.next())
                                    {
		user=rs.getString(1).toString();
		pass=rs.getString(2).toString();
		desg=rs.getString(3).toString();
		if(UN.equals(user)&&PW.equals(pass)&&DESG.equals(desg))
			flag=1;
		
		}
		
		if(flag==1)
		{		
		if(UN.equals("admin"))
			srp.sendRedirect("http://localhost:7001/supermarket/reporthome.html");
		else
		                  srp.sendRedirect("http://localhost:7001/supermarket/billerhome.html");
				
		}
		else
		{
		srp.sendRedirect("http://localhost:7001/supermarket/invalid.html");
		}
	
		}
	

		catch(Exception e)
		{
			out.println("Exception caught : " +e);
		}

	}
}
