package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.AnswerModel;

public class AnswerMapper implements IRowMapper<AnswerModel> {

	@Override
	public AnswerModel mapRow(ResultSet rs) {
		try {
			AnswerModel answer = new AnswerModel();
			answer.setId(rs.getLong("id"));
			answer.setQuestionId(rs.getLong("question_id"));
			answer.setContent(rs.getString("content"));
			answer.setResult(rs.getInt("result"));
			
			return answer;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
