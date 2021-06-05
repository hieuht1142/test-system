package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.SubjectModel;

public class SubjectMapper implements IRowMapper<SubjectModel> {

	@Override
	public SubjectModel mapRow(ResultSet rs) {
		try {
			SubjectModel subject = new SubjectModel();
			subject.setId(rs.getLong("id"));
			subject.setSubjectId(rs.getString("subject_id"));
			subject.setSubjectTitle(rs.getString("subject_title"));
			
			return subject;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
