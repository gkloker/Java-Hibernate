package com.mycompany.dao;

import com.mycompany.domain.Student;
import javax.persistence.Query;
import java.util.List;

public class StudentDAO extends GenericDAO {
  public List<Student> list() {
    String hsql = "SELECT s FROM Student s";
    em = getEntityManager();
    Query query = em.createQuery(hsql);

    return query.getResultList();
  }

  public void insert(Student student) {
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.persist(student);
      em.getTransaction().commit();

    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
  }

  public void update(Student student) {
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.merge(student);
      em.getTransaction().commit();

    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
  }

  public void delete(Student student) {
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.remove(em.merge(student));
      em.getTransaction().commit();

    } catch (Exception ex) {
      ex.printStackTrace(System.out);

    }
  }

  public Student searchStudentId(Student student) {
    em = getEntityManager();

    return em.find(Student.class, student.getIdStudent());
  }
}
