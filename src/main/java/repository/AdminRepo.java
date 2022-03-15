package repository;

import entity.DocumentType;
import entity.Request;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public class AdminRepo extends UserRepo{
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public List<User> findAllUsers(){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        String sql = "SELECT * FROM user;";
        Query query = em.createNativeQuery(sql,User.class);
        List<User> users = query.getResultList();
        em.close();
        return users;
    }

    public boolean createNewDocumentType(String documentName){
        DocumentType doc = findDocumentByName(documentName);
        if(doc != null)
            return false;
        DocumentType documentType = new DocumentType();
        documentType.setId(UUID.randomUUID().toString());
        documentType.setDocumentType(documentName);
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(documentType);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    public void deleteDocument(String documentName){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        DocumentType document = findDocumentByName(documentName);
        DocumentType documentType = em.find(DocumentType.class,document.getId());
        em.remove(documentType);
        em.getTransaction().commit();
        em.close();
    }

    public List<Request> getAllRequests(){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        String sql = "select * from request;";
        Query query = em.createNativeQuery(sql, Request.class);
        List<Request> results = query.getResultList();
        em.close();
        return results;
    }

    public void deleteRequest(String request){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Request document = findRequestByName(request);
        Request request1 = em.find(Request.class,document.getId());
        em.remove(request1);
        em.getTransaction().commit();
        em.close();
    }

    public void approveRequest(String requestDescription, Date date){
        Request request = findRequestByNameAndDate(requestDescription,date);
        if(request!=null){
            EntityManager em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();
            request.setApproved(true);
            em.merge(request);
            em.getTransaction().commit();
            em.close();
        }
    }

    public List<Request> getRequestsByType(DocumentType documentType){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        String sql = "SELECT * FROM request WHERE document_type_id='"+documentType.getId()+"';";
        Query query = em.createNativeQuery(sql,Request.class);
        List<Request> requests = query.getResultList();
        em.close();
        return  requests;
    }


}
