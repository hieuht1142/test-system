package dao.impl;

import java.util.List;

import dao.IExamDao;
import mapper.ExamMapper;
import model.ExamModel;

public class ExamDao extends GenericDao<ExamModel> implements IExamDao {

	@Override
	public List<ExamModel> find(String subjectId, String subjectTitle, String semester) {
		StringBuilder sql = new StringBuilder("SELECT * FROM exam WHERE ");
		sql.append("subject_id LIKE ? AND subject_title LIKE ? AND semester LIKE ?");
		
		return query(sql.toString(), new ExamMapper(), "%" + subjectId + "%", 
						"%" + subjectTitle + "%", "%" + semester + "%");
	}

	@Override
	public Long save(ExamModel exam) {
		StringBuilder sql = new StringBuilder("INSERT INTO exam (subject_id, subject_title, time, semester, ");
		sql.append("creator, createdDate, lastModified) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?)");
		
		return insert(sql.toString(), exam.getSubjectId(), exam.getSubjectTitle(), exam.getTime(), exam.getSemester(), 
						exam.getCreator(), exam.getCreatedDate(), exam.getLastModified());
	}

	@Override
	public void update(ExamModel exam) {
		StringBuilder sql = new StringBuilder("UPDATE exam SET subject_id = ?, subject_title = ?, time = ?, ");
		sql.append("semester = ?, createdDate = ?, lastModified = ? WHERE id = ?");
		
		update(sql.toString(), exam.getSubjectId(), exam.getSubjectTitle(), exam.getTime(), exam.getSemester(), 
						exam.getCreator(), exam.getCreatedDate(), exam.getLastModified(), exam.getId());
		
	}

	@Override
	public void delete(Long examId) {
		update("DELETE FROM exam_question WHERE question_id = ?", examId);
		update("DELETE FROM exam WHERE id = ?", examId);
	}

}
