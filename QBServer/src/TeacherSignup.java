

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TeacherSignup")
public class TeacherSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TeacherSignup() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String contact=request.getParameter("contact");
		String gender=request.getParameter("gender");
		
		try{
			Connection c;
			PreparedStatement ps;
			Class.forName("com.mysql.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/qbms","root","");
			String Query="INSERT into tempteacher (UserName, Email, Password, Gender, ContactNo)" 
			+ "VALUES(? , ? , ? , ? , ?)";
			ps=c.prepareStatement(Query);
			ps.setString(1, username);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setString(4, gender);
			ps.setString(5, contact);
			ps.executeUpdate();
			ps.close();
			c.close();
			response.sendRedirect("index.jsp");
			
		}catch(Exception e){
		}

	}

}
