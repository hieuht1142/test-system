package dao.impl;

import java.util.List;

import dao.IQuestionDao;
import mapper.QuestionMapper;
import model.QuestionModel;

public class QuestionDao extends GenericDao<QuestionModel> implements IQuestionDao {

	@Override
	public List<QuestionModel> find(String subjectId, String subjectTitle, String topic) {
		StringBuilder sql = new StringBuilder("SELECT * FROM question WHERE ");
		sql.append("subject_id LIKE ? AND subject_title LIKE ? AND topic LIKE ?");
		
		return query(sql.toString(), new QuestionMapper(), "%" + subjectId + "%", 
						"%" + subjectTitle + "%", "%" + topic + "%");
	}

	@Override
	public Long save(QuestionModel question) {
		StringBuilder sql = new StringBuilder("INSERT INTO question (subject_id, subject_title, topic, content, )");
		sql.append("creator, createdDate, lastModified) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?)");
		
		return insert(sql.toString(), question.getSubjectId(), question.getSubjectTitle(), question.getTopic(), 
				question.getContent(), question.getCreator(), question.getCreatedDate(), question.getLastModified());
	}

	@Override
	public void update(QuestionModel question) {
		StringBuilder sql = new StringBuilder("UPDATE question SET subject_id = ?, subject_title = ?, ");
		sql.append("topic = ?, content = ?, creator = ?, createdDate = ?, lastModified = ? ");
		sql.append("WHERE id = ?");
		
		update(sql.toString(), question.getSubjectId(), question.getSubjectTitle(), question.getTopic(), 
				question.getContent(), question.getCreator(), question.getCreatedDate(), 
				question.getLastModified(), question.getId());
	}

	@Override
	public void delete(Long questionId) {
		update("DELETE FROM exam_question WHERE question_id = ?", questionId);
		update("DELETE FROM answer WHERE question_id = ?", questionId);
		update("DELETE FROM question WHERE id = ?", questionId);
	}


}
