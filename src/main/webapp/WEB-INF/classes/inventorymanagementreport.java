import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class inventorymanagementreport extends HttpServlet
{
	public void doGet(HttpServletRequest srq,HttpServletResponse srp) throws IOException,ServletException
	{
		PrintWriter out=srp.getWriter();
		String Companyid=srq.getParameter("Companyid");
		PreparedStatement ps = null;
		String typeofclientt="";
		String repaymenthistoryy="";
		String baddebitss="";
		String totaloutstandingg="";







		
		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:wsm","","");

		ps  = con.prepareStatement("select typeofclient,repaymenthistory,baddebits,totaloutstanding  from  inventorymanagement where  Companyid=? order by baddebits");
		ps.setString(1,Companyid);
		ps.executeQuery();
		ResultSet rs = ps.getResultSet();
out.println("<center><font style=verdhana color=#990099><b><u><h3>SEARCH RESULTS</h3></b><u></font></center>");
out.println("<a href=home.html><b>Home</b></a></center>");

		while(rs.next())
		{
                        out.println("<body background=bg.jpg>");
		

	                 out.println("<table background=b1.jpg border=8 cellpadding=8 cellspacing=4 align=center width=600 height=200>");
		out.println("	<tr><td><b> Company id </b></td>");

	                out.println(" <td><b>"+Companyid+"<b></td></tr>");

	               out.println(" <tr><td><b>Type of Client</b></td>");

	               out.println("<td><b>"+typeofclientt+"<b></td></tr>");

	               out.println("<tr><td><b>Repayment History</b></td>");

                                 out.println("<td>" +repaymenthistoryy+"</td></tr>");	

	               out.println("<tr><td><b>Bad debits</b></td>");

                              out.println("<td>" +baddebitss+"</td></tr>");
out.println("<tr><td><b>Total Out Standing</b></td>");

                              out.println("<td>" +totaloutstandingg+"</td></tr>");

		
		out.println("<a href=reporthome.html>AdminHome</a>");

		out.println("</table><br>");
		
		typeofclientt= rs.getString("typeofclient");
		repaymenthistoryy= rs.getString("repaymenthistory");
		baddebitss= rs.getString("baddebits");
		totaloutstandingg= rs.getString("totaloutstanding");
		
		
		}
		
		}
	

		catch(Exception e)
		{
			out.println("Exception caught : " +e);
		}
		
	}
}

