package service.impl;

import java.util.List;

import dao.IAnswerDao;
import dao.IExamDao;
import dao.IQuestionDao;
import model.ExamModel;
import model.QuestionModel;
import service.IExamService;

public class ExamService implements IExamService {
	
	private IExamDao examDao;
	private IQuestionDao questionDao;
	private IAnswerDao answerDao;

	@Override
	public List<ExamModel> find(String subjectId, String subjectTitle, String semester) {
		return examDao.find(subjectId, subjectTitle, semester);
	}
	
	@Override
	public ExamModel findById(Long examId) {
		ExamModel exam = examDao.findById(examId).get(0);
		List<QuestionModel> questions = questionDao.findByExamId(examId);
		for (int i = 0; i < questions.size(); i++) {
			questions.get(i).setAnswerList(answerDao.findByQuestionId(questions.get(i).getId()));
		}
		exam.setQuestionList(questions);
		
		return exam;
	}

	@Override
	public Long save(ExamModel exam) {
		Long id = examDao.save(exam);
		
		if (id != null) {
			List<QuestionModel> questions = exam.getQuestionList();
			for (int i = 0; i < questions.size(); i++) {
				examDao.addQuestion(id, questions.get(i).getId());
			}
		}
		
		return id;
	}

	@Override
	public void update(ExamModel exam) {
		
		
	}

	@Override
	public void delete(Long examId) {
		
		
	}

	
}
