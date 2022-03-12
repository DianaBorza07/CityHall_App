package repository;

import entity.DocumentType;
import entity.Request;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class AdminRepo {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");


    public User findUserById(String id){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class,id);
        em.getTransaction().commit();
        em.close();
        return  user;
    }

    public List<User> findAllUsers(){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        String sql = "SELECT * FROM user;";
        Query query = em.createNativeQuery(sql,User.class);
        List<User> users = query.getResultList();
        em.close();
        return users;
    }

    public void createNewDocumentType(String documentName){
        DocumentType documentType = new DocumentType();
        documentType.setId(UUID.randomUUID().toString());
        documentType.setDocumentType(documentName);
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(documentType);
        em.getTransaction().commit();
        em.close();
    }

    public DocumentType findDocumentByName(String documentName){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        String sql = "SELECT * FROM documenttype where documentType='"+documentName+"';";
        Query query = em.createNativeQuery(sql,DocumentType.class);
        List<DocumentType> documentTypes = query.getResultList();
        DocumentType document = documentTypes.get(0);
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






}
