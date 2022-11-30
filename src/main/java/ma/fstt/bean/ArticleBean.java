package ma.fstt.bean;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

import ma.fstt.persistence.Article;
import ma.fstt.persistence.DatabaseOperationsArticle;
import ma.fstt.persistence.DatabaseOperationsUser;
import ma.fstt.persistence.Internaute;
@ManagedBean(name = "ArticleBean")
@RequestScoped
public class ArticleBean {

	private String codeArticle;
	private String nomArticle;
	private Double prixArticle;
	private Part uploadedFile;


	public Part getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(Part uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public String getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(String codeArticle) {
		this.codeArticle = codeArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public Double getPrixArticle() {
		return prixArticle;
	}

	public void setPrixArticle(Double prixArticle) {
		this.prixArticle = prixArticle;
	}


	public String ajouter() throws MalformedURLException, URISyntaxException {
		
		System.out.println("saveFile method invoked..");
		System.out.println( "content-type:{0}" + uploadedFile.getContentType());
		System.out.println("filename:{0}" + uploadedFile.getName());
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		URL input = externalContext.getResource("/resources/images/");
		System.out.println(input.toURI().getPath());
	
		 String fileName = "";
		
		  try {
			  
			  fileName = getFilename(uploadedFile);
			  
			  System.out.println("fileName  " + fileName);
			  
			  uploadedFile.write(input.toURI().getPath()+fileName);
			  System.out.println(input.toURI().getPath());
//				<img src="http://localhost:8080/AtelierJsf/resources/images/Picture1.jpg" />
	        } catch (IOException ex) {
	            System.out.println(ex);
	            
	            
	        }
		  Article ar=new Article();
		  ar.setCodeArticle(codeArticle);
		  ar.setNomArticle(nomArticle);
		  ar.setPrixArticle(prixArticle);
		  ar.setImage(fileName);
		  DatabaseOperationsUser dou=new DatabaseOperationsUser();
		  ar.setAdmin(dou.isNotCreated());
		  DatabaseOperationsArticle articleDAO= new DatabaseOperationsArticle();
		  articleDAO.save(ar);
		  return "articles.xhtml?faces-redirect=true";
		
	}
	
	
	private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }
	
	public List<Article> getAll() {
		DatabaseOperationsArticle articleDAO= new DatabaseOperationsArticle();
		return articleDAO.getAll();
	}
	public String supprimer(Integer id) {
		DatabaseOperationsArticle articleDAO= new DatabaseOperationsArticle();
		articleDAO.supprimer(id);
		return "articles.xhtml?faces-redirect=true";
	}

	public String editer(Integer id) {



    	DatabaseOperationsArticle doa=new DatabaseOperationsArticle();
    	Article article= doa.modifier(id);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("article", article);
		return "accueil.xhtml?faces-redirect=true";
	}
	
	public String  modifierArt(Article a) throws MalformedURLException, URISyntaxException {
		DatabaseOperationsArticle articleDAO= new DatabaseOperationsArticle();
		System.out.println("xsss");
		System.out.println("saveFile method invoked..");
		System.out.println( "content-type:{0}" + uploadedFile.getContentType());
		System.out.println("filename:{0}" + uploadedFile.getName());
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		URL input = externalContext.getResource("/resources/images/");
		System.out.println(input.toURI().getPath());
	
		 String fileName = "";

		  try {
			  
			  fileName = getFilename(uploadedFile);
			  
			  System.out.println("fileName  " + fileName);
			  
			  uploadedFile.write(input.toURI().getPath()+fileName);
			  System.out.println(input.toURI().getPath());
//				<img src="http://localhost:8080/AtelierJsf/resources/images/Picture1.jpg" />
	        } catch (IOException ex) {
	            System.out.println(ex);
	            
	            
	        }

		  a.setImage(fileName);
		  DatabaseOperationsUser dou=new DatabaseOperationsUser();
		  a.setAdmin(dou.isNotCreated());

		  
		articleDAO.update(a);
		return "articles.xhtml?faces-redirect=true";
			
	}


}
