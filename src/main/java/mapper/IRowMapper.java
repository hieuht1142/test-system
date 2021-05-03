package mapper;

import java.sql.ResultSet;

public interface IRowMapper<T> {
	
	/**
	 * Mapping data from result set to model T
	 * 
	 * @param rs Result set
	 * @return model T
	 */
	T mapRow(ResultSet rs);
}
