package dao;

import java.util.List;

import model.QuestionModel;

public interface IQuestionDao extends IGenericDao<QuestionModel> {
	
	List<QuestionModel> find(String subjectId, String subjectTitle, String topic);
	
	List<QuestionModel> findByExamId(Long examId);
	
	Long save(QuestionModel question);
	
	void update(QuestionModel question);
	
	void delete(Long questionId);

}
