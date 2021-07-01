package com.mycompany.dao;

import com.mycompany.domain.Course;
import javax.persistence.Query;
import java.util.List;

public class CourseDAO extends GenericDAO {
  public List<Course> list() {
    String hsql = "SELECT c FROM Course c";
    em = getEntityManager();
    Query query = em.createQuery(hsql);

    return query.getResultList();
  }

  public void insert(Course course) {
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.persist(course);
      em.getTransaction().commit();

    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
  }

  public void update(Course course) {
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.merge(course);
      em.getTransaction().commit();

    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
  }

  public void delete(Course course) {
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.remove(em.merge(course));
      em.getTransaction().commit();

    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
  }

  public Course searchCourseId(Course course) {
    em = getEntityManager();

    return em.find(Course.class, course.getIdCourse());
  }
}
