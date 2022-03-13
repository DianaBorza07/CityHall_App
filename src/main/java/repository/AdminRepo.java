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

public class AdminRepo {
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
        Query query = em.createNativeQuery(sql,DocumentType.class);
        List<Request> requests = query.getResultList();
        Request request = null;
        if(requests.size()!=0)
            request = requests.get(0);
        em.close();
        return request;
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
        else System.out.println("ceva");
    }


}
