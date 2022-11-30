package ma.fstt.bean;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Column;


import ma.fstt.persistence.DatabaseOperationsUser;
import ma.fstt.persistence.Internaute;

@ManagedBean(name = "InternauteBean")
@RequestScoped
public class InternauteBean {
	private String email;
	private String password; 
	private String role;
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String register() {
		Internaute In= new Internaute();
		In.setRole("user");
		DatabaseOperationsUser dou=new DatabaseOperationsUser();
		In.setAdmin(dou.isNotCreated());
		In.setEmail(email);
		In.setPassword(password);
		In.setPrenom(prenom);
		In.setNom(nom);
		In.setAdresse(adresse);
		In.setTelephone(telephone);
		DatabaseOperationsUser userDAO= new DatabaseOperationsUser();
		userDAO.save(In);
		return  "authentifier.xhtml?faces-redirect=true";
	}
	
	public List<Internaute> getAll() {
		DatabaseOperationsUser userDAO= new DatabaseOperationsUser();
		return userDAO.getAll();
	}
	public String supprimer(Integer id) {
		DatabaseOperationsUser userDAO= new DatabaseOperationsUser();
		userDAO.supprimer(id);
		return "users.xhtml?faces-redirect=true";
	}
}
