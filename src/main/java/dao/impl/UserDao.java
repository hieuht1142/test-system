package dao.impl;

import java.util.List;

import dao.IUserDao;
import mapper.UserMapper;
import model.UserModel;

public class UserDao extends GenericDao<UserModel> implements IUserDao {

	@Override
	public UserModel findAccount(String username, String password) {
		String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
		List<UserModel> users = query(sql, new UserMapper(), username, password);
		return users.isEmpty() ? null : users.get(0);
	}

}
