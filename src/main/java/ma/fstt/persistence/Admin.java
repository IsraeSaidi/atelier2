package ma.fstt.persistence;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "admin")

public class Admin extends Personne{
	@OneToMany(mappedBy="admin",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<Internaute> internautes;
	
	@OneToMany(mappedBy="admin",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<Article> articles;

	public List<Internaute> getInternautes() {
		return internautes;
	}

	public void setInternautes(List<Internaute> internautes) {
		this.internautes = internautes;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
}
