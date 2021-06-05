package dao.impl;

import java.util.List;

import dao.IExamDao;
import mapper.ExamMapper;
import mapper.QuestionMapper;
import model.ExamModel;
import model.QuestionModel;

public class ExamDao extends GenericDao<ExamModel> implements IExamDao {

	@Override
	public List<ExamModel> find(Long subject, String semester) {
		StringBuilder sql = new StringBuilder("SELECT * FROM exam WHERE ");
		sql.append("subject = ? AND semester LIKE ?");
		
		return query(sql.toString(), new ExamMapper(), subject, "%" + semester + "%");
	}
	
	@Override
	public ExamModel findById(Long examId) {
		String sql = "SELECT * FROM exam WHERE id = ?";
		List<ExamModel> exams = query(sql, new ExamMapper(), examId);
		
		return exams.isEmpty() ? null : exams.get(0);
	}

	@Override
	public Long save(ExamModel exam) {
		StringBuilder sql = new StringBuilder("INSERT INTO exam (subject, time, semester, ");
		sql.append("creator, createdDate, lastModified, status) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?)");
		
		return insert(sql.toString(), exam.getSubject(), exam.getTime(), exam.getSemester(), 
						exam.getCreator(), exam.getCreatedDate(), exam.getLastModified(), exam.getStatus());
	}

	@Override
	public void update(ExamModel exam) {
		StringBuilder sql = new StringBuilder("UPDATE exam SET subject = ?, time = ?, ");
		sql.append("semester = ?, creator = ?, createdDate = ?, lastModified = ? WHERE id = ?");
		
		update(sql.toString(), exam.getSubject(), exam.getTime(), exam.getSemester(), 
						exam.getCreator(), exam.getCreatedDate(), exam.getLastModified(), exam.getId());
		
	}

	@Override
	public void delete(Long examId) {
		update("DELETE FROM exam_question WHERE exam_id = ?", examId);
		update("DELETE FROM exam WHERE id = ?", examId);
	}

	@Override
	public void addQuestion(Long examId, Long questionId) {
		String sql = "INSERT INTO exam_question (exam_id, question_id) VALUES (?, ?)";
		insertPair(sql, examId, questionId);
	}

	@Override
	public void removeQuestion(Long examId, Long questionId) {
		String sql = "DELETE FROM exam_question WHERE exam_id = ? AND question_id = ?";
		update(sql, examId, questionId);
		
	}

	@Override
	public List<QuestionModel> findQuestion(Long examId) {
		StringBuilder sql = new StringBuilder("SELECT * FROM question JOIN exam_question ");
		sql.append("ON question.id = question_id WHERE exam_id = ?");
		return query(sql.toString(), new QuestionMapper(), examId);
	}
	

}
