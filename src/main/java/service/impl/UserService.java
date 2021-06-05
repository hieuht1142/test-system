package service.impl;

import javax.inject.Inject;

import dao.IUserDao;
import model.UserModel;
import service.IUserService;

public class UserService implements IUserService {
	
	@Inject
	private IUserDao userDao;

	@Override
	public UserModel findAccount(String username, String password) {
		return userDao.findAccount(username, password);
	}

}
