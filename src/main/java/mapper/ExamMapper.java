package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.ExamModel;

public class ExamMapper implements IRowMapper<ExamModel> {

	@Override
	public ExamModel mapRow(ResultSet rs) {	
		try {
			ExamModel exam = new ExamModel();
			exam.setId(rs.getLong("id"));
			exam.setSubjectId(rs.getString("subject_id"));
			exam.setSubjectTitle(rs.getString("subject_title"));
			exam.setTime(rs.getLong("time"));
			exam.setSemester(rs.getString("semester"));
			exam.setCreator(rs.getLong("creator"));
			exam.setCreatedDate(rs.getTimestamp("createdDate"));
			exam.setLastModified(rs.getTimestamp("lastModified"));
			
			return exam;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
