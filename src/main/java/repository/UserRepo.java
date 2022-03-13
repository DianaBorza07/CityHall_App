package repository;

import dto.UserDTO;
import entity.User;
import entity.UserRole;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class UserRepo {
	
	private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");
	
	public Boolean insertNewUser(User user) {
		if(findUserByUsername(user.getUsername())!=null)
			return false;
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
		return true;
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

	public User findUserByUsername(String username){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		StringBuilder sqlQuery = new StringBuilder("SELECT * FROM user WHERE username='");
		sqlQuery.append(username);
		sqlQuery.append("';");
		Query query = em.createNativeQuery(sqlQuery.toString(),User.class);
		List<User> results = query.getResultList();
		User user=null;
		if(results.size()!=0)
			user = results.get(0);
		em.close();
		return  user;
	}

	public UserRole getUserRole(User user){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		String sql = "SELECT roleName from user,userrole where userrole.id = user.id and user.id='"+user.getId()+"';";
		Query query = em.createNativeQuery(sql,UserRole.class);
		List<UserRole> userRoles = query.getResultList();
		em.close();
		return userRoles.get(0);
	}


}
