package model;

import dao.AccountsDAO;

public class LoginLogic {
  public boolean execute(Login login) {
	  AccountsDAO dao = new AccountsDAO();
	  Account acount = dao.findByLogin(login);
	  return acount != null;
  }
}
