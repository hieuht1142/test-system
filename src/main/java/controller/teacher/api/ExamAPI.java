package controller.teacher.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.ExamModel;
import model.UserModel;
import service.IExamService;
import utils.HttpUtil;
import utils.SessionUtil;

@WebServlet(urlPatterns = {"/api-teacher-exam"})
public class ExamAPI extends HttpServlet {

	private static final long serialVersionUID = -4378817039382696580L;
	
	@Inject
	private IExamService examService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		ExamModel exam = HttpUtil.of(request.getReader()).toModel(ExamModel.class);
		
		// todo: set creator
		exam.setCreator(((UserModel) SessionUtil.getInstance().getValue(request, "USER")).getId());
		
		examService.save(exam);
		
		// convert model to json
		mapper.writeValue(response.getOutputStream(), exam);
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ExamModel exam = HttpUtil.of(request.getReader()).toModel(ExamModel.class);
		
		examService.update(exam);
		
		mapper.writeValue(response.getOutputStream(), exam);	
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		ExamModel exam = HttpUtil.of(request.getReader()).toModel(ExamModel.class);
		
		examService.delete(exam.getIds());
		
		mapper.writeValue(response.getOutputStream(), "{}");
		
	}

}
