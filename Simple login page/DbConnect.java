import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConnect{
	public int insert(String firstname, String lastname, String dob, String email) throws SQLException, ClassNotFoundException {
		if(firstname!="" && lastname!="" && dob!="" && email!="") {
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Person","root","18052005@Moni");
			String query="insert into detail(firstname, lastname, dob, email) values(?,?,?,?)";
			PreparedStatement ps=c.prepareStatement(query);
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, dob);
			ps.setString(4, email);
			int row=ps.executeUpdate();
			System.out.println(row);
			return row;
		}
		else {
			return 0;
		}
		
		
	}
}
