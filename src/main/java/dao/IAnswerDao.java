package dao;

import java.util.List;

import model.AnswerModel;

public interface IAnswerDao extends IGenericDao<AnswerModel> {
	
	/**
	 * Find answers by question id
	 * 
	 * @param questionId question id
	 * @return List of found answers
	 */
	List<AnswerModel> findByQuestionId(Long questionId);
	
	/**
	 * Save an answer into database
	 * @param answer answer
	 * @return id of the answer in database
	 */
	Long save(AnswerModel answer);
	
	/**
	 * Modify an answer in database
	 * @param answer answer
	 */
	void update(AnswerModel answer);

}
