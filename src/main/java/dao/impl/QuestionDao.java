package dao.impl;

import java.util.List;

import dao.IQuestionDao;
import mapper.QuestionMapper;
import model.QuestionModel;
import paging.Pageble;

public class QuestionDao extends GenericDao<QuestionModel> implements IQuestionDao {

	@Override
	public List<QuestionModel> find(Long subject, String topic) {
		StringBuilder sql = new StringBuilder("SELECT * FROM question WHERE ");
		sql.append("subject = ? AND topic LIKE ?");
		
		return query(sql.toString(), new QuestionMapper(), subject, "%" + topic + "%");
	}
	
	@Override
	public QuestionModel findById(Long id) {
		String sql = "SELECT * FROM question WHERE id = ?";
		List<QuestionModel> questions = query(sql, new QuestionMapper(), id);
		
		return questions.isEmpty() ? null : questions.get(0);
	}
	
	@Override
	public List<QuestionModel> findByExamId(Long examId) {
		StringBuilder sql = new StringBuilder("SELECT * FROM question JOIN exam_question ");
		sql.append("ON id = question_id WHERE exam_id = ?");
		return query(sql.toString(), new QuestionMapper(), examId);
	}

	@Override
	public Long save(QuestionModel question) {
		StringBuilder sql = new StringBuilder("INSERT INTO question (subject, topic, content, ");
		sql.append("answer_a, answer_b, answer_c, answer_d, true_answer, creator, createdDate, lastModified, status) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
		return insert(sql.toString(), question.getSubject(), question.getTopic(), 
				question.getContent(), question.getAnswerA(), question.getAnswerB(), question.getAnswerC(), 
				question.getAnswerD(), question.getTrueAnswer(), question.getCreator(), 
				question.getCreatedDate(), question.getLastModified(), question.getStatus());
	}

	@Override
	public void update(QuestionModel question) {
		StringBuilder sql = new StringBuilder("UPDATE question SET subject = ?, topic = ?, ");
		sql.append("content = ?, answer_a = ?, answer_b = ?, answer_c = ?, answer_d = ?, true_answer = ?, ");
		sql.append("creator = ?, createdDate = ?, lastModified = ? WHERE id = ?");
		
		update(sql.toString(), question.getSubject(), question.getTopic(), question.getContent(), 
				question.getAnswerA(), question.getAnswerB(), question.getAnswerC(), question.getAnswerD(), 
				question.getTrueAnswer(), question.getCreator(), question.getCreatedDate(), 
				question.getLastModified(), question.getId());
	}

	@Override
	public void delete(Long questionId) {
		//update("DELETE FROM exam_question WHERE question_id = ?", questionId);
		update("DELETE FROM question WHERE id = ?", questionId);
	}

	@Override
	public List<QuestionModel> findAll(Pageble pageble, Long examId, Long subject) {
		StringBuilder sql = new StringBuilder("SELECT * FROM question ");
		sql.append("WHERE id NOT IN (SELECT question_id FROM exam_question WHERE exam_id = ?) AND subject = ?");
		
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT " + pageble.getOffset() + ", " + pageble.getLimit());
			return query(sql.toString(), new QuestionMapper(), examId, subject);
		}
		
		return null;
	}

	@Override
	public int getTotalItems(Long examId, Long subject) {
		String sql = "SELECT COUNT(*) FROM question WHERE id NOT IN (SELECT question_id FROM exam_question WHERE exam_id = ?) AND subject = ?";
		return count(sql, examId, subject);
	}

	@Override
	public List<QuestionModel> findAll(Pageble pageble, Long subject, String topic) {
		StringBuilder sql = new StringBuilder("SELECT * FROM question ");
		sql.append("WHERE subject = ? AND topic LIKE ?");
		
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT " + pageble.getOffset() + ", " + pageble.getLimit());
			return query(sql.toString(), new QuestionMapper(), subject, "%" + topic + "%");
		}
		
		return null;
	}

	@Override
	public int getTotalItems(Long subject, String topic) {
		String sql = "SELECT COUNT(*) FROM question WHERE subject = ? AND topic LIKE ?";
		return count(sql, subject, "%" + topic + "%");
	}

}
