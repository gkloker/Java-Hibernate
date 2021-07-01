package com.mycompany.test;

import com.mycompany.dao.*;
import com.mycompany.domain.Contact;

import java.util.List;

public class TestDAO {
  public static void main(String[] args) {
    StudentDAO studentDAO = new StudentDAO();
    System.out.println("Students =========================");
    print(studentDAO.list());

    System.out.println("Address =========================");
    AddressDAO addressDAO = new AddressDAO();
    print(addressDAO.list());

    System.out.println("Contact =========================");
    ContactDAO contactDAO = new ContactDAO();
    print(contactDAO.list());

    // Add contact
    Contact c = new Contact();
//    c.setEmail("mkloker");
//    c.setPhone("1135088770");
//    contactDAO.insert(c);


    c.setIdContact(3);
    c = contactDAO.searchAddressId(c);

    // Update
//    c.setEmail("mkloker@gmail.com");
//    contactDAO.update(c);
//    System.out.println("Edit new Contact: " + c);

    //Delete
//    contactDAO.delete(c);

    System.out.println("Courses =========================");
    CourseDAO courseDAO = new CourseDAO();
    print(courseDAO.list());

    System.out.println("Assignments =========================");
    AssignmentDAO assignmentDAO = new AssignmentDAO();
    print(assignmentDAO.list());
  }

  private static void print(List collection) {
    for (Object obj: collection) System.out.println("value: " + obj);
  }
}
