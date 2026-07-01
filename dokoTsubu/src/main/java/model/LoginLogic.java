package model;

import dao.UserDAO;

public class LoginLogic {
  public User execute(User user) {
	  UserDAO dao = new UserDAO();
	 
	  return dao.findByLogin(user);
  }
}