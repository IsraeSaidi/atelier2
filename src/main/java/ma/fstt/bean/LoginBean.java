package ma.fstt.bean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;

import ma.fstt.persistence.DatabaseOperationsUser;
import ma.fstt.persistence.Internaute;
import ma.fstt.persistence.Personne;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;




@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean {
	
	private String pwd;
	private String msg;
	private String email;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//validate login
	public String validateUsernamePassword()  {
		DatabaseOperationsUser loginDAO= new DatabaseOperationsUser();
		Personne p =loginDAO.validate(email, pwd);
		if(p==null) {
			return  "authentifier.xhtml?faces-redirect=true";
		}else if(p.getRole().equals("admin")) {
			System.out.println(p.getRole());
			HttpSession session =getSession();
			session.setAttribute("user", p);
			return  "accueil.xhtml?faces-redirect=true";
		}else if (p.getRole().equals("user")){
			System.out.println(p.getRole());
			HttpSession session =getSession();
			session.setAttribute("user", p);
			return  "vitrine.xhtml?faces-redirect=true";
		}else {
			return  "authentifier.xhtml?faces-redirect=true";
		}

	}
//
//	//logout event, invalidate session
	public String logout() {

		
		
		HttpSession session = getSession();
		session.invalidate();
		return  "accueil.xhtml?faces-redirect=true";
	}
	public static HttpSession getSession()  {

		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
	}
	


}
