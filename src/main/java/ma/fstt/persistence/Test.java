package ma.fstt.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {

	public static void main(String[] args) {
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("PERSISTENCE");
				EntityManager em = emf.createEntityManager();


	}

}
