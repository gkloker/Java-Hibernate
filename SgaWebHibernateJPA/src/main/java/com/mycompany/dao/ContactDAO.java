package com.mycompany.dao;

import com.mycompany.domain.Contact;
import javax.persistence.Query;
import java.util.List;

public class ContactDAO extends GenericDAO {
  public List<Contact> list() {
    String hsql = "SELECT c FROM Contact c";
    em = getEntityManager();
    Query query = em.createQuery(hsql);

    return query.getResultList();
  }

  public void insert(Contact contact) {
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.persist(contact);
      em.getTransaction().commit();

    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
  }

  public void update(Contact contact) {
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.merge(contact);
      em.getTransaction().commit();

    } catch (Exception ex) {
      ex.printStackTrace(System.out);

    }
  }

  public void delete(Contact contact) {
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.remove(em.merge(contact));
      em.getTransaction().commit();

    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
  }

  public Contact searchAddressId(Contact contact) {
    em = getEntityManager();

    return em.find(Contact.class, contact.getIdContact());
  }
}
