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
import model.QuestionModel;
import model.UserModel;
import paging.PageRequest;
import paging.Pageble;
import service.IQuestionService;
import service.ISubjectService;
import utils.FormUtil;
import utils.SessionUtil;

@WebServlet(urlPatterns = {"/teacher-question"})
public class QuestionController extends HttpServlet {

	private static final long serialVersionUID = -8953369495749728857L;
	
	@Inject
	private IQuestionService questionService;
	
	@Inject
	private ISubjectService subjectService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuestionModel model = FormUtil.toModel(QuestionModel.class, request);
		String view = "";
		String type = request.getParameter("type");
		
		if (type.equals("create")) {
			view = "views/teacher/question/create.jsp";
		} else if (type.equals("list")) {
			if (model.getSubject() != null) {	
				
				Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem());
				
				model.setListQuestions(questionService.findAll(pageble, model.getSubject(), model.getTopic()));
				
				request.setAttribute("subjectModel", subjectService.findById(model.getSubject()));
				
				model.setTotalItems(questionService.getTotalItems(model.getSubject(), model.getTopic()));
				model.setTotalPage((int) Math.ceil((double) model.getTotalItems() / model.getMaxPageItem()));
			}
			
			view = "views/teacher/question/questions.jsp";
		} else if (type.equals("update")) {
			model = questionService.findById(model.getId());
			view = "views/teacher/question/update.jsp";
		}	
		
		UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request, "USER");
		request.setAttribute("subjects", subjectService.findAll(userModel.getId()));
		request.setAttribute(SystemConstant.QUESTION, model);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
}
