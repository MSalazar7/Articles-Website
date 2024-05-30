package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Article;
import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession();
		User currUser = new User();
		
		Connection c = null;
		try {
    		String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu26";
    		String username = "cs3220stu26";
    		String  password = "2B4HkOdPv2Ot";
    		
    	
    		String user = request.getParameter("username");
    		String pass = request.getParameter("password");
    		
    		
    		c = DriverManager.getConnection(url,username, password);
    		Statement stmt = c.createStatement();
    		ResultSet rs = stmt.executeQuery("select * from users");
    		
    		String userTest = "";
    		String passTest = "";
    			
    		
    		while(rs.next()) {
    			if(rs.getString("username").equals(user) && rs.getString("password").equals(pass)) {
    				currUser.setName(rs.getString("name"));
    				currUser.setUsername(rs.getString("username"));
    				currUser.setPassword(rs.getString("password"));
    				currUser.setAuthor(rs.getInt("is_author"));
    				currUser.setEditor(rs.getInt("is_editor"));
    				userTest = rs.getString("username");
        			passTest = rs.getString("password");
    				
    			}
    			
    			
    			
    		}
    		if(!userTest.equals(user) && !passTest.equals(pass)) {
    			request.getRequestDispatcher("Login.jsp").forward(request, response);
    		}
   
    	}
    	catch(SQLException e) {
    		throw new ServletException(e);
    	}
       finally {
    	   try {
    		   if(c != null) {
    			   c.close();
    		   }
    	   }
    	   catch(SQLException e) {
       		throw new ServletException(e);
       	}
       }
		session.setAttribute("user", currUser);
		request.getRequestDispatcher("ListArticles.jsp").forward(request, response);
	}

}
