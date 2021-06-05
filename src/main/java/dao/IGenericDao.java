package dao;

import java.util.List;

import mapper.IRowMapper;

public interface IGenericDao<T> {
	
	/**
	 * Select
	 */
	<T> List<T> query(String sql, IRowMapper<T> mapper, Object... params);
	
	/**
	 * Update or delete
	 */
	void update(String sql, Object... params);
	
	/**
	 * Insert
	 */
	Long insert(String sql, Object... params);
	
	void insertPair(String sql, Object... params);
	
	public int count(String sql, Object... params);
}
