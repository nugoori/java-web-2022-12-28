package service;

import database.DAO.UserDAO;

public class UserService {
	
	private UserDAO userDao;
	
	public UserService () {
		this.userDao = new UserDAO();
	}

}
