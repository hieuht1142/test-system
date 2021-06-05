package controller.teacher.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.QuestionModel;
import model.UserModel;
import service.IQuestionService;
import utils.HttpUtil;
import utils.SessionUtil;

@WebServlet(urlPatterns = {"/api-teacher-question"})
public class QuestionAPI extends HttpServlet {

	private static final long serialVersionUID = -4051951040591076057L;
	
	@Inject
	private IQuestionService questionService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		QuestionModel question = HttpUtil.of(request.getReader()).toModel(QuestionModel.class);
		
		// todo: set creator
		question.setCreator(((UserModel) SessionUtil.getInstance().getValue(request, "USER")).getId());
		
		questionService.save(question);
		
		// convert model to json
		mapper.writeValue(response.getOutputStream(), question);
		
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		QuestionModel question = HttpUtil.of(request.getReader()).toModel(QuestionModel.class);
		
		questionService.update(question);
		
		// convert model to json
		mapper.writeValue(response.getOutputStream(), question);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		QuestionModel question = HttpUtil.of(request.getReader()).toModel(QuestionModel.class);
		
		questionService.delete(question.getIds());
		
		// convert model to json
		mapper.writeValue(response.getOutputStream(), "{}");
	}
	
}
