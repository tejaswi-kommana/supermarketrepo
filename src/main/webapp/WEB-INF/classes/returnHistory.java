import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class returnHistory extends HttpServlet
{
	public void doGet(HttpServletRequest srq,HttpServletResponse srp) throws IOException,ServletException
	{
		PrintWriter out=srp.getWriter();
		String Companyid=srq.getParameter("Companyid");
		String typeofclient=srq.getParameter("typeofclient");
		String companyname=srq.getParameter("companyname");
		String stdindustrailcode=srq.getParameter("stdindustrailcode");
		String annualsales=srq.getParameter("annualsales");
		String aggrescredit=srq.getParameter("aggrescredit");
		String paymenthistory=srq.getParameter("paymenthistory");
		
		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:wsm","","");

		PreparedStatement ps=con.prepareStatement("insert into  returnHistory  values(?,?,?,?,?,?,?);");
		ps.setString(1,Companyid); ps.setString(2,typeofclient); ps.setString(3,companyname); ps.setString(4,stdindustrailcode);
ps.setString(5,annualsales); ps.setString(6,aggrescredit); ps.setString(7,paymenthistory); 
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


		
		

