package repository;

import dto.UserDTO;
import entity.Address;
import entity.DocumentType;
import entity.Request;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

public class RegularUserRepo extends UserRepo{

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public User findUserById(String id){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class,id);
        em.getTransaction().commit();
        em.close();
        return  user;
    }

    public List<Request> findRequests(Address address){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        String sql = "SELECT * FROM request where address_id='"+address.getId()+"';";
        Query query = em.createNativeQuery(sql,Request.class);
        List<Request> requests = query.getResultList();
        em.close();
        return requests;
    }

    public void insertNewRequest(Request request) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(request);
        em.getTransaction().commit();
        em.close();

    }

    public BigInteger getNumberOfRequests(Request request){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        String sql = "SELECT count(id) FROM request where address_id='"+request.getAddress().getId()+"' and document_type_id='"+request.getDocumentType().getId()+"';";
        Query query = em.createNativeQuery(sql);
        BigInteger val = (BigInteger) query.getSingleResult();
        em.close();
        return val;
    }

    public void deleteRequest(Request request){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Request request1 = em.find(Request.class,request.getId());
        em.remove(request1);
        em.getTransaction().commit();
        em.close();
    }

    public void updateRequest(String requestName, String newName, DocumentType documentType){
        Request request = findRequestByName(requestName);
        if(request!=null){
            EntityManager em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();
            request.setDescription(newName);
            request.setDocumentType(documentType);
            em.merge(request);
            em.getTransaction().commit();
            em.close();
        }
    }

    public void addAddress(Address address){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(address);
        em.getTransaction().commit();
        em.close();
    }

    public Address findAddress(User user, String number, String street){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        StringBuilder sql = new StringBuilder("SELECT * FROM address WHERE user_id='");
        sql.append(user.getId());
        sql.append("' and number='");
        sql.append(number);
        sql.append("' and street='");
        sql.append(street);
        sql.append("';");
        Query query = em.createNativeQuery(sql.toString(),Address.class);
        List<Address> addressList = query.getResultList();
        em.close();
        return addressList.get(0);
    }

    public List<Address> getAllAddresses(User user){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        String sql = "SELECT * FROM address WHERE user_id='"+user.getId()+"';";
        Query query = em.createNativeQuery(sql,Address.class);
        List<Address> addressList = query.getResultList();
        em.close();
        return  addressList;
    }

    public void deleteAddress(Address address){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Address request1 = em.find(Address.class,address.getId());
        em.remove(request1);
        em.getTransaction().commit();
        em.close();
    }

    public Address getAddressByName(User user, String number, String street){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        String sql = "SELECT * FROM address WHERE user_id='"+user.getId()+"' and number='"+number+"' and street='"+street+"';";
        Query query = em.createNativeQuery(sql,Address.class);
        List<Address> addressList = query.getResultList();
        em.close();
        return  addressList.get(0);
    }
}
