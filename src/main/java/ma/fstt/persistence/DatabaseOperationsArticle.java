package ma.fstt.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DatabaseOperationsArticle {
	static EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	public void save(Article ar) {
		entity.getTransaction().begin();
		entity.persist(ar);
		entity.getTransaction().commit();	
	}
	
	public List<Article> getAll() {
		List<Article> articles = new ArrayList<>();
		Query q = entity.createQuery("SELECT a FROM Article a");
		articles = q.getResultList();
		return articles;
	}
	public void supprimer(Integer id) {
		Article a = new Article();
		a= entity.find(Article.class, id);
		entity.getTransaction().begin();
		entity.remove(a);
		entity.getTransaction().commit();
	}
	public static Article getOne(Integer id) {
		Article a = new Article();
		a= entity.find(Article.class, id);
		entity.getTransaction().begin();
		entity.persist(a);
		entity.getTransaction().commit();
		return a;
}
	
	public void update(Article article) {
		entity.getTransaction().begin();
		entity.merge(article);
		entity.getTransaction().commit();
		/// JPAUtil.shutdown();
	}


	public Article modifier(Integer id) {
		Article c = new Article();
		c = entity.find(Article.class, id);
		// JPAUtil.shutdown();
		return c;
	}
}
