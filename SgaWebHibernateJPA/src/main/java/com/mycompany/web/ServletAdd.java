package com.mycompany.web;

import com.mycompany.domain.Address;
import com.mycompany.domain.Contact;
import com.mycompany.domain.Student;
import com.mycompany.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/ServletAdd")
public class ServletAdd extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    request.getRequestDispatcher("/WEB-INF/addStudent.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String street = request.getParameter("street");
    String numStreet = request.getParameter("numStreet");
    String country = request.getParameter("country");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");

    Address address = new Address();
    address.setStreet(street);
    address.setNumStreet(numStreet);
    address.setCountry(country);

    Contact contact = new Contact();
    contact.setEmail(email);
    contact.setPhone(phone);

    Student student = new Student();
    student.setFirstName(firstName);
    student.setLastName(lastName);
    student.setAddress(address);
    student.setContact(contact);

    StudentService studentService = new StudentService();
    studentService.saveStudent(student);

    request.getRequestDispatcher("/listStudents.jsp").forward(request, response);
  }
}
