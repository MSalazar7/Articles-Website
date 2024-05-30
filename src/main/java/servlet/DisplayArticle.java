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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Article;

/**
 * Servlet implementation class DisplayArticle
 */
@WebServlet("/DisplayArticle")
public class DisplayArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayArticle() {
        super();
        // TODO Auto-generated constructor stub
    }
    @SuppressWarnings("unchecked")
   	private Article getArticle(int id) {
       	List<Article> articles = (List<Article>) getServletContext().getAttribute("articles");
       	for(Article a : articles)
       		if(a.getId()==id)  return a;
      
       	return null;
       }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String articleId = request.getParameter("id");
		Article a = new Article();
		//Article a = getArticle(Integer.parseInt(id));
		//response.setContentType("text/html");
		int id = 0;
		Connection con = null;
    	try {
    		String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu26";
    		String username = "cs3220stu26";
    		String  password = "2B4HkOdPv2Ot";
    		
    		con = DriverManager.getConnection(url,username, password);
    		
    		Statement stmt = con.createStatement();
    		String sql = "select * from articles where id = ?";
    		PreparedStatement pstmt = con.prepareStatement(sql);
    		pstmt.setString(1, articleId);
    		ResultSet rs = pstmt.executeQuery();
    		
    		if(rs.next()) {
    			
    			a.setTitle(rs.getString("title"));
    			a.setExcerpt(rs.getString("excerpt"));
    			a.setContent(rs.getString("content"));
    			
    		}
   
    		
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
		getServletContext().setAttribute("a", a);
		request.getRequestDispatcher("DisplayArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
