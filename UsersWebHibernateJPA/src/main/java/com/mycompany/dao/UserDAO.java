package com.mycompany.dao;

import com.mycompany.domain.User;
import java.util.List;
import javax.persistence.*;

public class UserDAO {

  private EntityManagerFactory emf;
  private EntityManager em;

  public UserDAO() {
    emf = Persistence.createEntityManagerFactory("Hibernate");
    em = emf.createEntityManager();
  }

  public List<User> list() {
    String hql = "SELECT u FROM User u";
    Query query = em.createQuery(hql);
    List<User> users = query.getResultList();
    
    return users;
  }

  public void insert(User user) {
    try {
      em.getTransaction().begin();
      em.persist(user);
      em.getTransaction().commit();

    } catch (Exception ex) {
      ex.printStackTrace(System.out);
      em.getTransaction().rollback();

    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void update(User user) {
    try {
      em.getTransaction().begin();
      em.merge(user);
      em.getTransaction().commit();

    } catch (Exception ex) {
      ex.printStackTrace(System.out);
      em.getTransaction().rollback();

    }
  }

  public void delete(User user) {
    try {
      em.getTransaction().begin();
      em.remove(em.merge(user));
      em.getTransaction().commit();

    } catch (Exception ex) {
      ex.printStackTrace(System.out);
      em.getTransaction().rollback();

    }
  }

  // Search User
  public User searchUserId(User u) {
    return em.find(User.class, u.getId());
  }
}
