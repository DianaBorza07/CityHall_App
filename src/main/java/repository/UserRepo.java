package repository;

import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class UserRepo {
	
	private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");
	
	public void insertNewUser(User user) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
	}

	public User findUser(String id){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		User user = em.find(User.class,id);
		em.getTransaction().commit();
		em.close();
		return  user;
	}

	public User findUserByCredentials(String username, String password){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		StringBuilder sqlQuery = new StringBuilder("SELECT * FROM user WHERE username='");
		sqlQuery.append(username);
		sqlQuery.append("' and password='");
		sqlQuery.append(password);
		sqlQuery.append("';");
		Query query = em.createNativeQuery(sqlQuery.toString(),User.class);
		List<User> results = query.getResultList();
		User user = results.get(0);
		em.close();
		return  user;
	}


}
