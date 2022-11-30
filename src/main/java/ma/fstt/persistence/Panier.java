package ma.fstt.persistence;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "panier")
public class Panier {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private int quantite;
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
	private Article article;
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "internaute_id")
	private Internaute internaute; 

	public Panier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Panier(Long id, int quantite, Internaute internaute, Article article) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.internaute = internaute;
		this.article = article;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Internaute getInternaute() {
		return internaute;
	}
	public void setInternaute(Internaute internaute) {
		this.internaute = internaute;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	
	
}
