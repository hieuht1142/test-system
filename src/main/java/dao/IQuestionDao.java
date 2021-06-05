package dao;

import java.util.List;

import model.QuestionModel;
import paging.Pageble;

public interface IQuestionDao extends IGenericDao<QuestionModel> {
	
	List<QuestionModel> find(Long subject, String topic);
	
	QuestionModel findById(Long id);
	
	List<QuestionModel> findByExamId(Long examId);
	
	Long save(QuestionModel question);
	
	void update(QuestionModel question);
	
	void delete(Long questionId);
	
	List<QuestionModel> findAll(Pageble pageble, Long examId, Long subject);
	
	int getTotalItems(Long examId, Long subject);
	
	List<QuestionModel> findAll(Pageble pageble, Long subject, String topic);
	
	int getTotalItems(Long subject, String topic);

}
