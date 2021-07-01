package com.mycompany.web;

import com.mycompany.domain.Student;
import com.mycompany.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/ServletController")
public class ServletController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    StudentService studentService = new StudentService();

    List<Student> students = studentService.listStudents();

    request.setAttribute("students", students);

    try {
      request.getRequestDispatcher("/WEB-INF/listStudents.jsp").forward(request, response);
    } catch (ServletException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
