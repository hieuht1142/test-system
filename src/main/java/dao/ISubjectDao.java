package dao;

import java.util.List;

import model.SubjectModel;

public interface ISubjectDao extends IGenericDao<SubjectModel> {
	
	SubjectModel find(Long id);
	SubjectModel find(String subjectTitle);
	List<SubjectModel> findAll();
	List<SubjectModel> findAll(Long teacherId);
	
}
