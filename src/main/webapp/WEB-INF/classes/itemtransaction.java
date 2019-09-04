import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class itemtransaction extends HttpServlet
{
	public void doGet(HttpServletRequest srq,HttpServletResponse srp) throws IOException,ServletException
	{
		PrintWriter out=srp.getWriter();
		String ITEMQUANTITY=srq.getParameter("ITEMQUANTITY");
		String ITEMID=srq.getParameter("ITEMID");
		String TRANSID=srq.getParameter("TRANSID");
		
		

		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:wsm","","");

		PreparedStatement ps=con.prepareStatement("insert into  itemtransaction  values(?,?,?);");
		ps.setString(1,ITEMQUANTITY); ps.setString(2,ITEMID); ps.setString(3,TRANSID); 
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


		
		

