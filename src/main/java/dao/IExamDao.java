package dao;

import java.util.List;

import model.ExamModel;

public interface IExamDao extends IGenericDao<ExamModel> {
	
	List<ExamModel> find(String subjectId, String subjectTitle, String semester);
	
	Long save(ExamModel exam);
	
	void update(ExamModel exam);
	
	void delete(Long examId);
}
