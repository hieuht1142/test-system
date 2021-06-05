package controller.login;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserModel;
import service.IUserService;
import utils.FormUtil;
import utils.SessionUtil;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1674048695903964901L;
	
	@Inject
	private IUserService userService;
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {		
		
		String message = request.getParameter("message");
		
		if (message != null) {
			request.setAttribute("message", resourceBundle.getString(message));
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("views/login/login.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		UserModel user = FormUtil.toModel(UserModel.class, request);
		
		user = userService.findAccount(user.getUsername(), user.getPassword());
		
		if (user != null) {
			SessionUtil.getInstance().putValue(request, "USER", user);
			
			if (user.getRole().equals("teacher")) {
				response.sendRedirect(request.getContextPath() + "/teacher-home");
			} else if (user.getRole().equals("admin")) {
				response.sendRedirect(request.getContextPath() + "/admin-home");
			} else if (user.getRole().equals("student")) {
				response.sendRedirect(request.getContextPath() + "/student-home");
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/login?message=user_pass_invalid");
		}
	}
	
}
