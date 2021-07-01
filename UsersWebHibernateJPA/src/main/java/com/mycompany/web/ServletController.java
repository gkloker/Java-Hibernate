package com.mycompany.web;

import com.mycompany.domain.User;
import com.mycompany.service.Service;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletController")
public class ServletController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    Service serviceUser = new Service();

    List<User> users = serviceUser.listUsers();

    request.setAttribute("users", users);

    try {
      request.getRequestDispatcher("/WEB-INF/list.jsp").forward(request, response);
    } catch (ServletException ex) {
      ex.printStackTrace(System.out);
    } catch (IOException ex) {
      ex.printStackTrace(System.out);
    }
  }
}
