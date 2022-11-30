package ma.fstt.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;









public class DatabaseOperationsPanier {
	static EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();


	public static String creerPanier(Internaute internaute,int qte, Article article) {
		
		entity.getTransaction().begin();
		Panier panier = new Panier(0L,qte,internaute,article);
		
		entity.persist(panier);
	
		entity.getTransaction().commit();	
		return "panier.xhtml?faces-redirect=true";	
	}
	
	@SuppressWarnings("unchecked")
	public List<Panier> afficherPanier(int id) {
		
		Query query = entity.createQuery("SELECT p FROM Panier p where p.internaute.id=:id");
		  return (List<Panier>)query.setParameter("id", id).getResultList();
		
		
		
	}
	
	
	public void supprimer(Long id) {
		Panier p = new Panier();
		p= entity.find(Panier.class, id);
		entity.getTransaction().begin();
		entity.remove(p);
		entity.getTransaction().commit();
	}
	
	public void update(Panier panier) {
		entity.getTransaction().begin();
		entity.merge(panier);
		entity.getTransaction().commit();
		/// JPAUtil.shutdown();
	}


	public Panier modifier(Long id) {
		Panier p = new Panier();
		p = entity.find(Panier.class, id);
		// JPAUtil.shutdown();
		return p;
	}
	
	
}
