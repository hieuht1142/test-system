package service;

import java.util.List;

import model.QuestionModel;

public interface IQuestionService {
	
	List<QuestionModel> find(String subjectId, String subjectTitle, String topic);
	
	Long save(QuestionModel question);
	
	void update(QuestionModel question);
	
	void delete(Long questionId);
}
