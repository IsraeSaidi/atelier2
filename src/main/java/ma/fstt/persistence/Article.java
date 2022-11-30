package ma.fstt.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "article")
public class Article implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String codeArticle;
	private String nomArticle;
	private Double prixArticle;
	private String image;
	@ManyToOne
	@JoinColumn(name ="admin_id")
	private Admin admin;

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
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
