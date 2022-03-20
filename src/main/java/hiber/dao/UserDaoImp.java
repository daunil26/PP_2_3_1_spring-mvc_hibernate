package hiber.dao;

import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private EntityManagerFactory entityManagerFactory;

   @Override
   public void add(User user) {
      EntityManager entityManager = entityManagerFactory.createEntityManager();
      try {
         entityManager.getTransaction().begin();
         entityManager.persist(user);
         entityManager.getTransaction().commit();
      } catch (Exception e) {
         entityManager.getTransaction().rollback();
         System.out.println(e.getMessage());
      }
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      List<User> userList = new ArrayList<>();
      EntityManager entityManager = entityManagerFactory.createEntityManager();
      try {
         Query query = entityManager.createQuery("from User");
         userList = query.getResultList();
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
      return userList;
   }

   @Override
   public void removeUserById(long id) {
      EntityManager entityManager = entityManagerFactory.createEntityManager();
      try {
         entityManager.getTransaction().begin();
         Query query = entityManager.createQuery("DELETE User where id=:id");
         query.setParameter("id", id);
         query.executeUpdate();
         entityManager.getTransaction().commit();
      } catch (Exception e) {
         entityManager.getTransaction().rollback();
         System.out.println(e.getMessage());
      }
   }

   @Override
   public User getUserById(long id) {
      User user = null;
      EntityManager entityManager = entityManagerFactory.createEntityManager();
      try {
         Query query = entityManager.createQuery("from User where id=:id");
         query.setParameter("id", id);
         user = (User) query.getSingleResult();
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
      return user;
   }

   @Override
   public void updateUserById(User user) {
      EntityManager entityManager = entityManagerFactory.createEntityManager();
      try {
         entityManager.getTransaction().begin();
         entityManager.merge(user);
         entityManager.getTransaction().commit();
      } catch (Exception e) {
         entityManager.getTransaction().rollback();
         System.out.println(e.getMessage());
      }
   }
}
