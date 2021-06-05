package model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class QuestionModel {

	private Long id;
	private Long subject;
	private String topic;
	private String content;
	private String answerA;
	private String answerB;
	private String answerC;
	private String answerD;
	private String trueAnswer;
	private Long creator;
	private Timestamp createdDate;
	private Timestamp lastModified;
	private List<QuestionModel> listQuestions = new ArrayList<>();
	private Long ids[];
	private Integer page;
	private Integer maxPageItem;
	private Integer totalPage;
	private Integer totalItems;
	private Integer status;
	
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
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAnswerA() {
		return answerA;
	}
	public void setAnswerA(String answerA) {
		this.answerA = answerA;
	}
	public String getAnswerB() {
		return answerB;
	}
	public void setAnswerB(String answerB) {
		this.answerB = answerB;
	}
	public String getAnswerC() {
		return answerC;
	}
	public void setAnswerC(String answerC) {
		this.answerC = answerC;
	}
	public String getAnswerD() {
		return answerD;
	}
	public void setAnswerD(String answerD) {
		this.answerD = answerD;
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
	public String getTrueAnswer() {
		return trueAnswer;
	}
	public void setTrueAnswer(String trueAnswer) {
		this.trueAnswer = trueAnswer;
	}
	public List<QuestionModel> getListQuestions() {
		return listQuestions;
	}
	public void setListQuestions(List<QuestionModel> listQuestions) {
		this.listQuestions = listQuestions;
	}
	public Long[] getIds() {
		return ids;
	}
	public void setIds(Long ids[]) {
		this.ids = ids;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getMaxPageItem() {
		return maxPageItem;
	}
	public void setMaxPageItem(Integer maxPageItem) {
		this.maxPageItem = maxPageItem;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
