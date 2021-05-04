package dao;

import java.util.List;

import model.ExamModel;

public interface IExamDao extends IGenericDao<ExamModel> {
	
	List<ExamModel> find(String subjectId, String subjectTitle, String semester);
	
	List<ExamModel> findById(Long examId);
	
	Long save(ExamModel exam);
	
	void update(ExamModel exam);
	
	void delete(Long examId);
	
	void addQuestion(Long examId, Long questionId);
	
	void removeQuestion(Long examId, Long questionId);

}
