package com.mycompany.dao;

import com.mycompany.domain.Address;
import javax.persistence.Query;
import java.util.List;

public class AddressDAO extends GenericDAO {
  public List<Address> list() {
    String hsql = "SELECT a FROM Address a";
    em = getEntityManager();
    Query query = em.createQuery(hsql);

    return query.getResultList();
  }

  public void insert(Address address) {
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.persist(address);
      em.getTransaction().commit();

    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
  }

  public void update(Address address) {
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.merge(address);
      em.getTransaction().commit();

    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
  }

  public void delete(Address address) {
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.remove(em.merge(address));
      em.getTransaction().commit();

    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
  }

  public Address searchAddressId(Address address) {
    em = getEntityManager();

    return em.find(Address.class, address.getIdAddress());
  }
}