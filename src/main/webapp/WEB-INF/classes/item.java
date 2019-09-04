import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class item extends HttpServlet
{
	public void doGet(HttpServletRequest srq,HttpServletResponse srp) throws IOException,ServletException
	{
		PrintWriter out=srp.getWriter();
		String ITEMID=srq.getParameter("ITEMID");
		String ITEMNAME=srq.getParameter("ITEMNAME");
		String ITEMQUANTITY=srq.getParameter("ITEMQUANTITY");
		String ITEMPRICE=srq.getParameter("ITEMPRICE");
		

		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:wsm","","");

		PreparedStatement ps=con.prepareStatement("insert into  item  values(?,?,?,?);");
		ps.setString(1,ITEMID); ps.setString(2,ITEMNAME); ps.setString(3,ITEMQUANTITY); ps.setString(4,ITEMPRICE);

	int n = ps.executeUpdate();
		
		if(n==1)
		{
		out.println("<html>");
		out.println("<body background=bg.gif>");
		out.println("<center><b>ITEM updation is completed !!<b></center>");
		out.println("<a href=home.html>HOME</a></center>");
		}
		else
		{
		out.println("<html>");
		out.println("<body>");
		out.println("<center><b> ITEM UPDATION IS FAILED !!<b></center>");
		out.println("<a href=home.html>HOME</a></center>");
		}

		}
		
		catch(Exception e)
		{
			out.println("Exception caught : " +e);
		}

	}
}


		
		

