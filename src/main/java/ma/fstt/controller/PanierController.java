package ma.fstt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ma.fstt.bean.LoginBean;
import ma.fstt.bean.PanierBean;
import ma.fstt.persistence.Article;
import ma.fstt.persistence.DatabaseOperationsArticle;
import ma.fstt.persistence.DatabaseOperationsUser;
import ma.fstt.persistence.Internaute;
import ma.fstt.persistence.Panier;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/PanierController")
public class PanierController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     String action="";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PanierController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		action = request.getParameter("action");
		String[] ac = action.split("\\?");
		String[] act = action.split("=");
		System.out.print(ac[0]);
		 if("ajouterpanier".equals(ac[0])){ // action 1
			 PanierBean panb = new PanierBean();
			 HttpSession session = request.getSession();
			Internaute internaute = (Internaute) session.getAttribute("user");
			
			Article ar = DatabaseOperationsArticle.getOne(Integer.parseInt(act[1]));
			
			panb.ajouterPanier(internaute,ar);
			
			
		
			 request.getRequestDispatcher("panier.xhtml").forward(request, response);

		 }
		 if("getPanier".equals(action)) {
			 request.getRequestDispatcher("panier.xhtml").forward(request, response);
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
