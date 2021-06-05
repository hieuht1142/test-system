package service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import dao.IExamDao;
import dao.IQuestionDao;
import model.ExamModel;
import model.QuestionModel;
import service.IExamService;

public class ExamService implements IExamService {
	
	@Inject
	private IExamDao examDao;
	
	@Inject
	private IQuestionDao questionDao;

	@Override
	public List<ExamModel> find(Long subject, String semester) {
		return examDao.find(subject, semester);
	}
	
	@Override
	public ExamModel findById(Long examId) {
		ExamModel exam = examDao.findById(examId);
		List<QuestionModel> questions = questionDao.findByExamId(examId);
		exam.setQuestionList(questions);
		
		return exam;
	}

	@Override
	public Long save(ExamModel exam) {
		exam.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		exam.setLastModified(new Timestamp(System.currentTimeMillis()));
		exam.setStatus(0);
		Long id = examDao.save(exam);
		
		return id;
	}

	@Override
	public void update(ExamModel exam) {
		ExamModel oldExam = examDao.findById(exam.getId());
		
		exam.setCreator(oldExam.getCreator());
		exam.setCreatedDate(oldExam.getCreatedDate());
		exam.setLastModified(new Timestamp(System.currentTimeMillis()));
		
		examDao.update(exam);
	}

	@Override
	public void delete(Long[] ids) {
		for (Long id: ids) {
			examDao.delete(id);
		}
	}

	@Override
	public List<QuestionModel> findQuestion(Long examId) {
		return examDao.findQuestion(examId);
	}

	@Override
	public void addQuestion(Long examId, Long questionId) {
		examDao.addQuestion(examId, questionId);
	}

	@Override
	public void removeQuestion(Long examId, Long questionId) {
		examDao.removeQuestion(examId, questionId);	
	}
}
