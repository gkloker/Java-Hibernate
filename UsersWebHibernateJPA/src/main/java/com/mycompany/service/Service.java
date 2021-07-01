package com.mycompany.service;

import com.mycompany.dao.UserDAO;
import com.mycompany.domain.User;
import java.util.List;

public class Service {
  private UserDAO userDao;

  public Service() {
    this.userDao = new UserDAO();
  }

  public List<User> listUsers() {
    return this.userDao.list();
  }
}
