import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class inventorymanagement extends HttpServlet
{
	public void doGet(HttpServletRequest srq,HttpServletResponse srp) throws IOException,ServletException
	{
		PrintWriter out=srp.getWriter();
		String Companyid=srq.getParameter("Companyid");
		String typeofclient=srq.getParameter("typeofclient");
		String companyname=srq.getParameter("companyname");
		String repaymenthistory=srq.getParameter("repaymenthistory");
		String baddebits=srq.getParameter("baddebits");
		String totaloutstanding=srq.getParameter("totaloutstanding");
	
		
		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:wsm","","");

		PreparedStatement ps=con.prepareStatement("insert into  inventorymanagement  values(?,?,?,?,?,?);");
		ps.setString(1,Companyid); ps.setString(2,typeofclient); ps.setString(3,companyname); ps.setString(4,repaymenthistory);
ps.setString(5,baddebits); ps.setString(6,totaloutstanding);  
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


		
		

