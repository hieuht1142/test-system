package dao;

import java.util.List;

import model.ExamModel;
import model.QuestionModel;

public interface IExamDao extends IGenericDao<ExamModel> {
	
	List<ExamModel> find(Long subject, String semester);
	
	ExamModel findById(Long examId);
	
	Long save(ExamModel exam);
	
	void update(ExamModel exam);
	
	void delete(Long examId);
	
	void addQuestion(Long examId, Long questionId);
	
	void removeQuestion(Long examId, Long questionId);
	
	List<QuestionModel> findQuestion(Long examId);

}
