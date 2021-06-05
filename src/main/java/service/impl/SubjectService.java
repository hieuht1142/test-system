package service.impl;

import java.util.List;

import javax.inject.Inject;

import dao.ISubjectDao;
import model.SubjectModel;
import service.ISubjectService;

public class SubjectService implements ISubjectService {
	
	@Inject
	private ISubjectDao subjectDao;

	@Override
	public List<SubjectModel> findAll() {
		return subjectDao.findAll();
	}

	@Override
	public SubjectModel findById(Long id) {
		return subjectDao.find(id);
	}

	@Override
	public List<SubjectModel> findAll(Long teacherId) {
		return subjectDao.findAll(teacherId);
	}

}
