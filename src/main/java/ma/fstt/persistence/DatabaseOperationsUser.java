package ma.fstt.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;









public class DatabaseOperationsUser {
	static EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	public void addAdmin() {
		Admin admin=new Admin();
		admin.setEmail("admin@gmail.com");
		admin.setPassword("admin123");
		admin.setRole("admin");
		entity.getTransaction().begin();
		entity.persist(admin);
		entity.getTransaction().commit();
	}
	
	public Admin isNotCreated() {
		Query q = entity.createQuery("SELECT a FROM Admin a where a.email = :email");
		q.setParameter("email","admin@gmail.com") ;
//		id=q.getFirstResult();
		List<Admin> admin=q.getResultList();
//		a = entity.find(Admin.class, id);
		if(admin.size()==0) {
			return null;
		}else{
			return admin.get(0);
		}
	}
	public Personne validate(String email,String password) {
		if(!entity.getTransaction().isActive()) {
			entity.getTransaction().begin();
		}
		int id;
		
		if(email.equals("admin@gmail.com") && password.equals("admin123")) {
			Query q = entity.createQuery("SELECT a FROM Admin a where a.email = :email and a.password = :pwd");
			q.setParameter("email",email) ;
			q.setParameter("pwd", password) ;
//			id=q.getFirstResult();
			List<Admin> admin=q.getResultList();
//			a = entity.find(Admin.class, id);
			System.out.println(admin.get(0).getPassword());
			return admin.get(0);
		}else {
			Query q = entity.createQuery("SELECT a FROM Internaute a where a.email = :email and a.password= :pwd");
			q.setParameter("email", email) ;
			q.setParameter("pwd", password) ;
			List<Internaute> i=q.getResultList();
			if(i.size()!=0) {
				System.out.println(i.get(0).getPassword());
				return i.get(0);
			}else {
				System.out.println("not exist");
				return null;
			}
		}

		//JPAUtil.shutdown();
	}
	public void save(Internaute in) {
		
		if(!entity.getTransaction().isActive()) {
		entity.getTransaction().begin();
	}
		entity.persist(in);
		entity.getTransaction().commit();	
	}
	
	
	
	public List<Internaute> getAll() {
		List<Internaute> users = new ArrayList<>();
		Query q = entity.createQuery("SELECT a FROM Internaute a");
		users = q.getResultList();
		return users;
	}
	
	public void supprimer(Integer id) {
		Internaute i = new Internaute();
		i= entity.find(Internaute.class, id);
		entity.getTransaction().begin();
		entity.remove(i);
		entity.getTransaction().commit();
	}
	
	
	
}
