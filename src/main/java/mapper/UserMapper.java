package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.UserModel;

public class UserMapper implements IRowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet rs) {
		try {
			UserModel user = new UserModel();
			
			user.setId(rs.getLong("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setName(rs.getString("name"));
			user.setDateOfBirth(rs.getDate("dob"));
			user.setEmail(rs.getString("email"));
			user.setRole(rs.getString("role"));
			
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
	}

}
