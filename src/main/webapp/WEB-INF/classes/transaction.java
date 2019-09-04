import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class transaction extends HttpServlet
{
	public void doGet(HttpServletRequest srq,HttpServletResponse srp) throws IOException,ServletException
	{
		PrintWriter out=srp.getWriter();
		String TRANID=srq.getParameter("TRANID");
		String TRANDATE=srq.getParameter("TRANDATE");
		String CREDITCARDNO=srq.getParameter("CREDITCARDNO");
		String CREDITCARDEXP=srq.getParameter("CREDITCARDEXP");
		String AMT=srq.getParameter("AMT");
		String EMPID=srq.getParameter("EMPID");
		

		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:wsm","","");

		PreparedStatement ps=con.prepareStatement("insert into  transaction  values(?,?,?,?,?,?,?);");
		ps.setString(1,TRANID); ps.setString(2,TRANDATE); ps.setString(3,CREDITCARDNO); ps.setString(4,CREDITCARDEXP);
ps.setString(5,CREDITCARDEXP); ps.setString(6,AMT); ps.setString(7,EMPID); 
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


		
		

