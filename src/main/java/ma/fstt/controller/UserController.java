package ma.fstt.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import ma.fstt.bean.LoginBean;
import ma.fstt.persistence.DatabaseOperationsUser;
import ma.fstt.persistence.Internaute;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     String action="";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		action = request.getParameter("action");
		 if("authentifier".equals(action)){ // action 1

			 DatabaseOperationsUser dou=new DatabaseOperationsUser();
			 if(dou.isNotCreated()==null) {
			 dou.addAdmin();
			 }
			 request.getRequestDispatcher("authentifier.xhtml").forward(request, response);
		 }else if("register".equals(action)) {
			 DatabaseOperationsUser dou=new DatabaseOperationsUser();
				 if(dou.isNotCreated()==null) {
					 dou.addAdmin();
				 }
			 request.getRequestDispatcher("register.xhtml").forward(request, response);
		 }else if("gererUsers".equals(action)) {
		 request.getRequestDispatcher("users.xhtml").forward(request, response);
		 	}else if("gererArticles".equals(action)) {
//		 request.getRequestDispatcher("users.xhtml").forward(request, response);
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
