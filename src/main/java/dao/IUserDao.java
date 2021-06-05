package dao;

import model.UserModel;

public interface IUserDao extends IGenericDao<UserModel> {
	
	UserModel findAccount(String username, String password);

}
