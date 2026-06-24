package model;

import dao.UserDAO;

public class LoginLogic {
	
	public User execute(
			String name,
			String pass) {
		
		UserDAO dao =
				new UserDAO();
		
		return dao.findByLogin(
				name,
				pass);
		
	}
}