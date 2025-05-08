import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DbConnectServlet")
public class DbConnectServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String firstname=req.getParameter("firstname");
		String lastname=req.getParameter("lastname");
		String dob=req.getParameter("dob");
		String email=req.getParameter("email");
		DbConnect db=new DbConnect();
		int res1=0;
		try {
			res1 = db.insert(firstname, lastname, dob, email);
			System.out.println("Inserted successfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(res1==1) {
			res.sendRedirect("Success.html");
		}
		else {
			res.sendRedirect("Failure.html");
		}
		
		
		
	}
	
}
