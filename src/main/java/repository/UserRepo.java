package repository;

import entity.DocumentType;
import entity.Request;
import entity.User;
import entity.UserRole;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.Date;
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

	public Request findRequestByNameAndDate(String name, Date date){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		String sql = "SELECT * FROM request where description='"+name+"' and date='"+date.toString()+"';";
		Query query = em.createNativeQuery(sql,Request.class);
		List<Request> requests = query.getResultList();
		Request request = null;
		if(requests.size()!=0)
			request = requests.get(0);
		em.close();
		return request;
	}

	public DocumentType findDocumentByName(String documentName){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		String sql = "SELECT * FROM documenttype where documentType='"+documentName+"';";
		Query query = em.createNativeQuery(sql,DocumentType.class);
		List<DocumentType> documentTypes = query.getResultList();
		DocumentType document = null;
		if(documentTypes.size()!=0)
			document = documentTypes.get(0);
		em.close();
		return document;
	}

	public List<DocumentType> getAllDocuments(){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		String sql = "SELECT * FROM documenttype;";
		Query query = em.createNativeQuery(sql,DocumentType.class);
		List<DocumentType> documentTypes = query.getResultList();
		em.close();
		return documentTypes;
	}

	public Request findRequestByName(String name){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		String sql = "SELECT * FROM request where description='"+name+"';";
		Query query = em.createNativeQuery(sql,Request.class);
		List<Request> requests = query.getResultList();
		Request request = null;
		if(requests.size()!=0)
			request = requests.get(0);
		em.close();
		return request;
	}


}
