package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Article;

/**
 * Servlet implementation class ListArticles
 */

@WebServlet(urlPatterns = "/ListArticles", loadOnStartup =1)
public class ListArticles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListArticles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init( config );
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        List<Article> articles = new ArrayList<Article>();
    	Connection c = null;
    	try {
    		String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu26";
    		String username = "cs3220stu26";
    		String  password = "2B4HkOdPv2Ot";
    		
    		c = DriverManager.getConnection(url,username, password);
    		Statement stmt = c.createStatement();
    		ResultSet rs = stmt.executeQuery("select * from articles");
    		String sql = "select * from categories where id in (select article_id from article_categories where article_id = (select id from articles where id = ?))";
    		PreparedStatement pstmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    		//pstmt.setString(1, rs.getString("id"));
    		//ResultSet rs2 = pstmt.executeQuery();
    		//rs.next();
    		
    		while(rs.next()) {
    			Article a = new Article();
        		a.setId(rs.getInt("id"));

    			a.setTitle(rs.getString("title"));
    			a.setExcerpt(rs.getString("excerpt"));
    			a.setContent(rs.getString("content"));
    			
    			pstmt.setInt(1, a.getId());
    			ResultSet rs2 = pstmt.executeQuery();
    			if(rs2.next()) {
    			System.out.println(rs2.getString("name"));
    			a.setCategory(rs2.getString("name"));
    			};
    			//a.setCategory(rs2.getString("name"));
    			//LocalDateTime time = LocalDateTime.parse(rs.getString("time_submitted"), formatter);
    			//LocalDateTime pubTime = LocalDateTime.parse(rs.getString("time_published"), formatter);
    			//a.setSubmitTime(time);
    	
    			
    			articles.add(a);
    			
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
		
    	getServletContext().setAttribute("articles", articles);
    	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
    	
    	//HttpSession session = request.getSession();
    	//session.setAttribute("articles", articles);
    	
    	request.getRequestDispatcher("ListArticles.jsp").forward(request, response);
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
