package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.QuestionModel;

public class QuestionMapper implements IRowMapper<QuestionModel> {

	@Override
	public QuestionModel mapRow(ResultSet rs) {
		try {
			QuestionModel question = new QuestionModel();
			question.setId(rs.getLong("id"));
			question.setSubjectId(rs.getString("subject_id"));
			question.setSubjectTitle(rs.getString("subject_title"));
			question.setTopic(rs.getString("topic"));
			question.setContent(rs.getString("content"));
			question.setCreator(rs.getLong("creator"));
			question.setCreatedDate(rs.getTimestamp("createdDate"));
			question.setLastModified(rs.getTimestamp("lastModified"));
			
			return question;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
