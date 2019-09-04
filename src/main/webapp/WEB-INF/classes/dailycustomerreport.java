import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class dailycustomerreport extends HttpServlet
{
	public void doGet(HttpServletRequest srq,HttpServletResponse srp) throws IOException,ServletException
	{
		PrintWriter out=srp.getWriter();
		String billdate=srq.getParameter("billdate");
		PreparedStatement ps = null;
		String billnoo="";
		String bcounterr="";
		String itemnamee="";
		String itemnumberr="";
String itemvaluee="";
String totall="";






		
		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:wsm","","");

		ps  = con.prepareStatement("select billno,bcounter,billerid,itemname,itemnumber,itemvalue,total  from  dailyCustomertransaction where  billdate=? order by total");
		ps.setString(1,billdate);
		ps.executeQuery();
		ResultSet rs = ps.getResultSet();
out.println("<center><font style=verdhana color=#990099><b><u><h3>SEARCH RESULTS</h3></b><u></font></center>");
out.println("<a href=reporthome.html><b>AdminHome</b></a></center>");

		while(rs.next())
		{
                        out.println("<body background=bg.jpg>");
		

	                 out.println("<table background=b1.jpg border=8 cellpadding=8 cellspacing=4 align=center width=600 height=200>");
		out.println("	<tr><td><b> BillDate </b></td>");

	                out.println(" <td><b>"+billdate+"<b></td></tr>");

	               out.println(" <tr><td><b>Bill Number</b></td>");

	               out.println("<td><b>"+billnoo+"<b></td></tr>");

	               out.println("<tr><td><b>Billing Counter</b></td>");

                                 out.println("<td>" +bcounterr+"</td></tr>");	

	               out.println("<tr><td><b>Item Name</b></td>");

                              out.println("<td>" +itemnamee+"</td></tr>");
out.println("<tr><td><b>Item Number</b></td>");

                              out.println("<td>" +itemnumberr+"</td></tr>");
out.println("<tr><td><b>Item value</b></td>");

                              out.println("<td>" +itemvaluee+"</td></tr>");
out.println("<tr><td><b>Total</b></td>");

                              out.println("<td>" +totall+"</td></tr>");

		
		out.println("<a href=home.html>Home</a>");

		out.println("</table><br>");
		
		billnoo= rs.getString("billno");
		bcounterr= rs.getString("bcounter");
		itemnamee= rs.getString("itemname");
		itemnumberr= rs.getString("itemnumber");
		itemvaluee= rs.getString("itemvalue");
		totall= rs.getString("total");
		
		}
		
		}
	

		catch(Exception e)
		{
			out.println("Exception caught : " +e);
		}
		
	}
}

