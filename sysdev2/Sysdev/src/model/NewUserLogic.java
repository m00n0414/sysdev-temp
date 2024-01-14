package model;

import dao.UserDao;

public class NewUserLogic {

	public int insert(User user) {

		UserDao userDao = new UserDao();

		userDao.insert(user);

		return 1;
	}
}