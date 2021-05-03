package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import dao.IGenericDao;
import mapper.IRowMapper;

public class GenericDao<T> implements IGenericDao<T> {
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
			String user = "root";
			String password = "000000";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Set parameters for prepared statement
	 * 
	 * @param statement
	 * @param params
	 */
	private void setParameters(PreparedStatement statement, Object... params) {
		try {
			for (int i = 0; i < params.length; i++) {
				Object param = params[i];
				
				if (param instanceof Long) {
					statement.setLong(i+1, (Long) param);
				} else if (param instanceof String) {
					statement.setString(i+1, (String) param);
				} else if (param instanceof Integer) {
					statement.setInt(i+1, (Integer) param);
				} else if (param instanceof Timestamp) {
					statement.setTimestamp(i+1, (Timestamp) param);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public <T> List<T> query(String sql, IRowMapper<T> mapper, Object... params) {
		
		List<T> results = new ArrayList<>();
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			
			setParameters(statement, params);
			
			rs = statement.executeQuery();
			
			while (rs.next()) {
				results.add(mapper.mapRow(rs));
			}
			
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				
				if (statement != null) {
					statement.close();
				}
				
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
				return null;
			}
		}
	}

	@Override
	public void update(String sql, Object... params) {
		Connection conn = null;
		PreparedStatement statement = null;
	
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);
			setParameters(statement, params);
			statement.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				
				if (statement != null) {
					statement.close();
				}
				
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public Long insert(String sql, Object... params) {
		ResultSet resultSet = null;
		Long id = null;
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			setParameters(statement, params);
			
			statement.executeUpdate();
			
			resultSet = statement.getGeneratedKeys();
			
			if (resultSet.next()) {
				id = resultSet.getLong(1);
			}
			
			conn.commit();
			
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			return id;
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				
				if (statement != null) {
					statement.close();
				}
				
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
				return null;
			}
		}
	}

}
