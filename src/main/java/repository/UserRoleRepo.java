package repository;

import entity.UserRole;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class UserRoleRepo {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public UserRole findUserRoleByName(String userRole){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        String sqlQuery = "SELECT * FROM userrole WHERE rolename='"+userRole+"';";
        Query query = em.createNativeQuery(sqlQuery,UserRole.class);
        List<UserRole> userRoleList = query.getResultList();
        UserRole userRole1 = userRoleList.get(0);
        em.close();
        return  userRole1;
    }
}
