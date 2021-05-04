package service.impl;

import java.util.List;

import dao.IAnswerDao;
import dao.IQuestionDao;
import model.AnswerModel;
import model.QuestionModel;
import service.IQuestionService;

public class QuestionService implements IQuestionService {
	
	private IQuestionDao questionDao;
	private IAnswerDao answerDao;

	@Override
	public List<QuestionModel> find(String subjectId, String subjectTitle, String topic) {
		List<QuestionModel> questions = questionDao.find(subjectId, subjectTitle, topic);
		
		for (int i = 0; i < questions.size(); i++) {
			questions.get(i).setAnswerList(answerDao.findByQuestionId(questions.get(i).getId()));
		}
		
		return questions;
	}

	@Override
	public Long save(QuestionModel question) {
		Long id = questionDao.save(question);
		
		List<AnswerModel> answers = question.getAnswerList();
		for (int i = 0; i < answers.size(); i++) {
			answerDao.save(answers.get(i));
		}
		
		return id;
	}

	@Override
	public void update(QuestionModel question) {
		questionDao.update(question);
		
		List<AnswerModel> answers = question.getAnswerList();
		for (int i = 0; i < answers.size(); i++) {
			answerDao.update(answers.get(i));
		}
	}

	@Override
	public void delete(Long questionId) {
		// todo: check if question can be deleted
		
		// delete questions
		questionDao.delete(questionId);
	}
	
}
