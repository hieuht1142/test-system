package dao.impl;

import java.util.List;

import dao.IAnswerDao;
import mapper.AnswerMapper;
import model.AnswerModel;

public class AnswerDao extends GenericDao<AnswerModel> implements IAnswerDao {

	@Override
	public List<AnswerModel> findByQuestionId(Long questionId) {
		String sql = "SELECT * FROM answer WHERE question_id = ?";
		return query(sql, new AnswerMapper(), questionId);
	}

	@Override
	public Long save(AnswerModel answer) {
		StringBuilder sql = new StringBuilder("INSERT INTO answer (question_id, content, result) ");
		sql.append("VALUES (?, ?, ?)");
		
		return insert(sql.toString(), answer.getQuestionId(), answer.getContent(), answer.getResult());
	}

	@Override
	public void update(AnswerModel answer) {
		StringBuilder sql = new StringBuilder("UPDATE answer SET question_id = ?, content = ?, result = ? ");
		sql.append("WHERE id = ?");
		
		update(sql.toString(), answer.getQuestionId(), answer.getContent(), answer.getResult(), answer.getId());
		
	}

}
