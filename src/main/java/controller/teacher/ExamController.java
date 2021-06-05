package controller.teacher;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constants.SystemConstant;
import model.ExamModel;
import model.QuestionModel;
import model.UserModel;
import paging.PageRequest;
import paging.Pageble;
import service.IExamService;
import service.IQuestionService;
import service.ISubjectService;
import utils.FormUtil;
import utils.SessionUtil;

@WebServlet(urlPatterns = {"/teacher-exam"})
public class ExamController extends HttpServlet {

	private static final long serialVersionUID = 831507479537868391L;
	
	@Inject
	private ISubjectService subjectService;
	
	@Inject
	private IExamService examService;
	
	@Inject
	private IQuestionService questionService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ExamModel model = FormUtil.toModel(ExamModel.class, request);
		String view = "";
		String type = request.getParameter("type");
		
		if (type.equals("create")) {
			view = "views/teacher/exam/create.jsp";
		} else if (type.equals("list")) {
			if (model.getSubject() != null) {
				model.setExamList(examService.find(model.getSubject(), model.getSemester()));
				request.setAttribute("subjectModel", subjectService.findById(model.getSubject()));
			}
			view = "views/teacher/exam/exams.jsp";
		} else if (type.equals("updateQuestion")) {
			if (model.getAddedQuestion() != null) {
				examService.addQuestion(model.getId(), model.getAddedQuestion());
			}
			
			if (model.getRemovedQuestion() != null) {
				examService.removeQuestion(model.getId(), model.getRemovedQuestion());
			}
			
			QuestionModel question = FormUtil.toModel(QuestionModel.class, request);
			
			Pageble pageble = new PageRequest(question.getPage(), question.getMaxPageItem());
			
			question.setListQuestions(questionService.findAll(pageble, model.getId(), model.getSubject()));
			question.setTotalItems(questionService.getTotalItems(model.getId(), model.getSubject()));
			question.setTotalPage((int) Math.ceil((double) question.getTotalItems() / question.getMaxPageItem()));
			
			request.setAttribute(SystemConstant.QUESTION, question);
			view = "views/teacher/exam/questions.jsp";
			
			model.setQuestionList(examService.findQuestion(model.getId()));
		} else if (type.equals("update")) {
			model = examService.findById(model.getId());
			
			view = "views/teacher/exam/update.jsp";
		}
		
		UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request, "USER");
		request.setAttribute("subjects", subjectService.findAll(userModel.getId()));
		request.setAttribute(SystemConstant.EXAM, model);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

}
