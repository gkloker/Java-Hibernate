package com.mycompany.test;

import com.mycompany.dao.StudentDAO;
import com.mycompany.domain.Address;
import com.mycompany.domain.Contact;
import com.mycompany.domain.Student;

public class TestCascadeDAO {
  public static void main(String[] args) {
    StudentDAO studentDAO = new StudentDAO();

    Address a = new Address();
    a.setStreet("Reconquista");
    a.setNumStreet("618");
    a.setCountry("Argentina");

    Contact c = new Contact();
    c.setEmail("jpaterno@compliance.com.ar");
    c.setPhone("1122334455");

    Student s = new Student();
    s.setFirstName("Jorge");
    s.setLastName("Paterno");
    s.setAddress(a);
    s.setContact(c);

    studentDAO.insert(s);

    System.out.println("Student = " + s);
  }
}
