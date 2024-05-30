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

import model.Article;
import model.User;

/**
 * Servlet implementation class UserRegistration
 */
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("UserRegistration.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Connection c = null;
		int id = 0;
    	try {
    		String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu26";
    		String username = "cs3220stu26";
    		String  password = "2B4HkOdPv2Ot";
    		
    		String name = request.getParameter("name");
    		String user = request.getParameter("username");
    		String pass = request.getParameter("password");
    		String editor = request.getParameter("editor");
    		String author = request.getParameter("author");
    		
    		c = DriverManager.getConnection(url,username, password);
    		String sql = "insert into users(name, username, is_editor, is_author, password) values (?,?,?,?,?)";
    		
    		
    		//ResultSet rs = stmt.executeQuery("select * from articles");
    		//String sql = "select * from categories where id in (select article_id from article_categories where article_id = (select id from articles where id = ?))";
    		//PreparedStatement pstmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    		//pstmt.setString(1, rs.getString("id"));
    		//ResultSet rs2 = pstmt.executeQuery();
    		//rs.next();
    		
    			
    		
    		PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    		
    		ps.setString(1, name);
    		ps.setString(2, user);
    		ps.setString(3, editor);
    		ps.setString(4, author);
    		ps.setString(5, pass);
    		ps.executeUpdate();
    		ResultSet rs = ps.getGeneratedKeys();
    		
    		if(rs.next()) id = rs.getInt(1);
    		ps.close();
   
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

    	request.getRequestDispatcher("ListArticles.jsp").forward(request, response);
	}

}
