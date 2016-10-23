

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

@WebServlet("/teacherlogin")
public class teacherlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public teacherlogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		try{
			Connection c;
			PreparedStatement ps;
			ResultSet rs;
			Class.forName("com.mysql.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/qbms","root","");
			String Query="SELECT * FROM teacherlogin";
			ps=c.prepareStatement(Query);
			rs=ps.executeQuery();
			
			while(rs.next()){
				if(username.equals(rs.getString("UserName"))&& password.equals(rs.getString("Password"))){
					response.sendRedirect("index.jsp");
				}
				response.sendRedirect("teacherlogin.jsp");
			}
			rs.close();
			ps.close();
			c.close();
		}catch(Exception e){
		}

	}

}
