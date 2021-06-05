package service;

import java.util.List;

import model.QuestionModel;
import paging.Pageble;

public interface IQuestionService {
	
	List<QuestionModel> find(Long subject, String topic);
	
	QuestionModel findById(Long id);
	
	Long save(QuestionModel question);
	
	void update(QuestionModel question);
	
	void delete(Long[] ids);
	
	List<QuestionModel> findAll(Pageble pageble, Long examId, Long subject);
	
	int getTotalItems(Long examId, Long subject);
	
	List<QuestionModel> findAll(Pageble pageble, Long subject, String topic);
	
	int getTotalItems(Long subject, String topic);
}
