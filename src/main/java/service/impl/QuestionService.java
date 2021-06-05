package service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import dao.IQuestionDao;
import model.QuestionModel;
import paging.Pageble;
import service.IQuestionService;

public class QuestionService implements IQuestionService {
	
	@Inject
	private IQuestionDao questionDao;
	
	@Override
	public List<QuestionModel> find(Long subject, String topic) {				
		return questionDao.find(subject, topic);
	}
	
	@Override
	public QuestionModel findById(Long id) {
		return questionDao.findById(id);
	}

	@Override
	public Long save(QuestionModel question) {
		question.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		question.setLastModified(new Timestamp(System.currentTimeMillis()));
		question.setStatus(0);
		return questionDao.save(question);
	}

	@Override
	public void update(QuestionModel question) {
		QuestionModel oldQuestion = questionDao.findById(question.getId());
		
		question.setCreator(oldQuestion.getCreator());
		question.setCreatedDate(oldQuestion.getCreatedDate());
		question.setLastModified(new Timestamp(System.currentTimeMillis()));
		
		questionDao.update(question);
	}

	@Override
	public void delete(Long[] ids) {
		for (Long id: ids) {
			questionDao.delete(id);
		}
	}

	@Override
	public List<QuestionModel> findAll(Pageble pageble, Long examId, Long subject) {
		return questionDao.findAll(pageble, examId, subject);
	}

	@Override
	public int getTotalItems(Long examId, Long subject) {
		return questionDao.getTotalItems(examId, subject);
	}

	@Override
	public List<QuestionModel> findAll(Pageble pageble, Long subject, String topic) {
		return questionDao.findAll(pageble, subject, topic);
	}

	@Override
	public int getTotalItems(Long subject, String topic) {
		return questionDao.getTotalItems(subject, topic);
	}
	
}
