package ma.fstt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.persistence.DatabaseOperationsUser;

/**
 * Servlet implementation class ArticleController
 */
@WebServlet("/ArticleController")
public class ArticleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String action="";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action = request.getParameter("action");
		if("gererArticles".equals(action)) {
		 request.getRequestDispatcher("articles.xhtml").forward(request, response);
		 	}else {
		 request.getRequestDispatcher("register.xhtml").forward(request, response);
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
