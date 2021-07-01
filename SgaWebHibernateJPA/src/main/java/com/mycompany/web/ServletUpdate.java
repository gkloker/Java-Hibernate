package com.mycompany.web;

import com.mycompany.domain.Address;
import com.mycompany.domain.Contact;
import com.mycompany.domain.Student;
import com.mycompany.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/ServletUpdate")
public class ServletUpdate extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    String idStudentString = request.getParameter("idStudent");
    Integer idStudent = Integer.parseInt(idStudentString);

    Student student = new Student();
    student.setIdStudent(idStudent);

    StudentService studentService = new StudentService();
    student = studentService.findStudent(student);

    //request.setAttribute("student", student);
    HttpSession session = request.getSession();
    session.setAttribute("student", student);

    request.getRequestDispatcher("/WEB-INF/updateStudent.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    StudentService studentService = new StudentService();

    String update = request.getParameter("Update");

    if (update != null) {
      String firstName = request.getParameter("firstName");
      String lastName = request.getParameter("lastName");
      String street = request.getParameter("street");
      String numStreet = request.getParameter("numStreet");
      String country = request.getParameter("country");
      String email = request.getParameter("email");
      String phone = request.getParameter("phone");

      HttpSession session = request.getSession();
      Student student = (Student) session.getAttribute("student");

      student.setFirstName(firstName);
      student.setLastName(lastName);
      student.getAddress().setStreet(street);
      student.getAddress().setNumStreet(numStreet);
      student.getAddress().setCountry(country);
      student.getContact().setEmail(email);
      student.getContact().setPhone(phone);

      studentService.saveStudent(student);

      session.removeAttribute("student");

    } else {
      String idStudentString = request.getParameter("idStudent");
      Integer idStudent = Integer.parseInt(idStudentString);
      Student student = new Student(idStudent);
      studentService.deleteStudent(student);
    }

    request.getRequestDispatcher("/index.jsp").forward(request, response);
  }
}
