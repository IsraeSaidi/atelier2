package ma.fstt.bean;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.servlet.http.HttpSession;

import ma.fstt.persistence.Article;
import ma.fstt.persistence.DatabaseOperationsArticle;
import ma.fstt.persistence.DatabaseOperationsPanier;
import ma.fstt.persistence.DatabaseOperationsUser;
import ma.fstt.persistence.Internaute;
import ma.fstt.persistence.Panier;
import ma.fstt.persistence.Personne;

@ManagedBean(name = "PanierBean")
@RequestScoped
public class PanierBean {
	private Long id;
	private int quantite;
	private Internaute internaute; 

	
	
	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Internaute getInternaute() {
		return internaute;
	}

	public void setInternaute(Internaute internaute) {
		this.internaute = internaute;
	}



	
	
public String  ajouterPanier(Internaute in, Article art) {
	
	
	 Panier panier=new Panier();
	  panier.setQuantite(quantite);
		return DatabaseOperationsPanier.creerPanier(in,1,art);
		
	}


public static List<Panier> getPanier(int id) {
	DatabaseOperationsPanier panierDAO= new DatabaseOperationsPanier();
	return panierDAO.afficherPanier(id);
}

public String supprimer(Long id) {
	DatabaseOperationsPanier panierDAO= new DatabaseOperationsPanier();
	panierDAO.supprimer(id);
	return "panier.xhtml?faces-redirect=true";
}

public String editer(Long id) {

	DatabaseOperationsPanier doa=new DatabaseOperationsPanier();
	Panier panier= doa.modifier(id);
	Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	sessionMap.put("panier", panier);
	return "modifierQte.xhtml?faces-redirect=true";
}

public String  modifierPanier(Panier a) throws MalformedURLException, URISyntaxException {
	DatabaseOperationsPanier panierDAO= new DatabaseOperationsPanier();
	a.setQuantite(quantite);
	panierDAO.update(a);
	return "panier.xhtml?faces-redirect=true";
		
}



 


	
	
	

}
