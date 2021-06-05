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
			question.setSubject(rs.getLong("subject"));
			question.setTopic(rs.getString("topic"));
			question.setContent(rs.getString("content"));
			question.setAnswerA(rs.getString("answer_a"));
			question.setAnswerB(rs.getString("answer_b"));
			question.setAnswerC(rs.getString("answer_c"));
			question.setAnswerD(rs.getString("answer_d"));
			question.setTrueAnswer(rs.getString("true_answer"));
			question.setCreator(rs.getLong("creator"));
			question.setCreatedDate(rs.getTimestamp("createdDate"));
			question.setLastModified(rs.getTimestamp("lastModified"));
			question.setStatus(rs.getInt("status"));
			
			return question;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
