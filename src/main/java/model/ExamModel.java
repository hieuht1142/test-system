package model;

import java.sql.Timestamp;
import java.util.List;

public class ExamModel {
	private Long id;
	private Long subject;
	private Long[] questions;
	private Long time;
	private String semester;
	private Long creator;
	private Timestamp createdDate;
	private Timestamp lastModified;
	private List<QuestionModel> questionList;
	private List<ExamModel> examList;
	private Long addedQuestion;
	private Long removedQuestion;
	private Integer status;
	private Long ids[];
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSubject() {
		return subject;
	}
	public void setSubject(Long subject) {
		this.subject = subject;
	}
	public Long[] getQuestions() {
		return questions;
	}
	public void setQuestions(Long[] questions) {
		this.questions = questions;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public Long getCreator() {
		return creator;
	}
	public void setCreator(Long creator) {
		this.creator = creator;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public Timestamp getLastModified() {
		return lastModified;
	}
	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}
	public List<QuestionModel> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<QuestionModel> questionList) {
		this.questionList = questionList;
	}
	public List<ExamModel> getExamList() {
		return examList;
	}
	public void setExamList(List<ExamModel> examList) {
		this.examList = examList;
	}
	public Long getAddedQuestion() {
		return addedQuestion;
	}
	public void setAddedQuestion(Long addedQuestion) {
		this.addedQuestion = addedQuestion;
	}
	public Long getRemovedQuestion() {
		return removedQuestion;
	}
	public void setRemovedQuestion(Long removedQuestion) {
		this.removedQuestion = removedQuestion;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long[] getIds() {
		return ids;
	}
	public void setIds(Long ids[]) {
		this.ids = ids;
	}
	
}
