package dao.impl;

import java.util.List;

import dao.ISubjectDao;
import mapper.SubjectMapper;
import model.SubjectModel;

public class SubjectDao extends GenericDao<SubjectModel> implements ISubjectDao {

	@Override
	public SubjectModel find(Long id) {
		String sql = "SELECT * FROM subject WHERE id = ?";
		List<SubjectModel> subjects = query(sql, new SubjectMapper(), id);
		
		return subjects.isEmpty() ? null : subjects.get(0);
	}

	@Override
	public SubjectModel find(String subjectTitle) {
		String sql = "SELECT * FROM subject WHERE subject_title = ?";
		List<SubjectModel> subjects = query(sql, new SubjectMapper(), subjectTitle);
		
		return subjects.isEmpty() ? null : subjects.get(0);
	}

	@Override
	public List<SubjectModel> findAll() {
		String sql = "SELECT * FROM subject";
		return query(sql, new SubjectMapper());
	}

	@Override
	public List<SubjectModel> findAll(Long teacherId) {
		String sql = "SELECT * FROM subject JOIN teacher_subject ON id = subjectId WHERE teacherId = ?";
		return query(sql, new SubjectMapper(), teacherId);
	}

}
