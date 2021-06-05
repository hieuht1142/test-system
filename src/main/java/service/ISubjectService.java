package service;

import java.util.List;

import model.SubjectModel;

public interface ISubjectService {
	
	List<SubjectModel> findAll();
	SubjectModel findById(Long id);
	List<SubjectModel> findAll(Long teacherId);

}
