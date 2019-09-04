import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class dailyCustomertransaction extends HttpServlet
{
	public void doGet(HttpServletRequest srq,HttpServletResponse srp) throws IOException,ServletException
	{
		PrintWriter out=srp.getWriter();
		String billno=srq.getParameter("billno");
		String billdate=srq.getParameter("billdate");
		String bcounter=srq.getParameter("bcounter");
		String billerid=srq.getParameter("billerid");
		String itemname=srq.getParameter("itemname");
		String itemnumber=srq.getParameter("itemnumber");
		String itemvalue=srq.getParameter("itemvalue");
		String total=srq.getParameter("total");

		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:wsm","","");

		PreparedStatement ps=con.prepareStatement("insert into  dailyCustomertransaction  values(?,?,?,?,?,?,?,?);");
		ps.setString(1,billno); ps.setString(2,billdate); ps.setString(3,bcounter); ps.setString(4,billerid);
ps.setString(5,itemname); ps.setString(6,itemnumber); ps.setString(7,itemvalue); ps.setString(8,total);
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


		
		

