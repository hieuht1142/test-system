package service;

import model.UserModel;

public interface IUserService {
	
	UserModel findAccount(String username, String password);

}
