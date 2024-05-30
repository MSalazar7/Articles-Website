package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Article;

/**
 * Servlet implementation class AddArticle
 */
@WebServlet("/AddArticle")
public class AddArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.getRequestDispatcher("AddArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String title = request.getParameter("title");
		String excerpt = request.getParameter("excerpt");
		String category = request.getParameter("Category");
		String content = request.getParameter("content");
		Article a = new Article(title, excerpt,category);
		a.setContent(content);
		List<Article> articles = (List<Article>) getServletContext().getAttribute("articles");
		
		int id = 0;
		Connection con = null;
    	try {
    		String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu26";
    		String username = "cs3220stu26";
    		String  password = "2B4HkOdPv2Ot";
    		
    		con = DriverManager.getConnection(url,username, password);
    		
    		String sql = "insert into articles (title, excerpt, content, house_name, author_id) values(?,?,?,?)";
    		PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    		pstmt.setString(1, a.getTitle());
    		pstmt.setString(2,a.getExcerpt());
    		pstmt.setString(3,a.getContent());
    		pstmt.setLong(4,a.getId());
    		pstmt.executeUpdate();
    		ResultSet rs = pstmt.getGeneratedKeys();
    		
    		if(rs.next()) id = rs.getInt(1);
    		pstmt.close();

    		
    
    	}
    	catch(SQLException e) {
    		throw new ServletException(e);
    	}
       finally {
    	   try {
    		   if(con != null) {
    			   con.close();
    		   }
    	   }
    	   catch(SQLException e) {
       		throw new ServletException(e);
       	}
       }
		articles.add(a);
		
		request.getRequestDispatcher("ListArticles.jsp").forward(request, response);
	}

}
