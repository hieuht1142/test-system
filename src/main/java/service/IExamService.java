package service;

import java.util.List;

import model.ExamModel;

public interface IExamService {
	
	List<ExamModel> find(String subjectId, String subjectTitle, String semester);
	
	ExamModel findById(Long examId);
	
	Long save(ExamModel exam);
	
	void update(ExamModel exam);
	
	void delete(Long examId);
}
