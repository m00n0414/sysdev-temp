package model;

import dao.UserDao;

public class LoginLogic {
	public boolean execute(User user) {

		UserDao userDao = new UserDao();

		boolean isLogin = userDao.findByIdAndPassword(user);

		return isLogin;

	}
}