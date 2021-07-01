package com.mycompany.dao;

import com.mycompany.domain.Assignment;
import javax.persistence.Query;
import java.util.List;

public class AssignmentDAO extends GenericDAO {
  public List<Assignment> list() {
    String hsql = "SELECT a FROM Assignment a";
    em = getEntityManager();
    Query query = em.createQuery(hsql);

    return query.getResultList();
  }

  public void insert(Assignment assignment) {
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.persist(assignment);
      em.getTransaction().commit();

    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
  }

  public void update(Assignment assignment) {
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.merge(assignment);
      em.getTransaction().commit();

    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
  }

  public void delete(Assignment assignment) {
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.remove(em.merge(assignment));
      em.getTransaction().commit();

    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
  }

  public Assignment searchAssignmentId(Assignment assignment) {
    em = getEntityManager();

    return em.find(Assignment.class, assignment.getIdAssignment());
  }
}
