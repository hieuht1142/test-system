package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserModel;
import utils.SessionUtil;

public class AuthorizationFilter implements Filter {
	
	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String url = request.getRequestURI();
		
		if (url.startsWith(request.getContextPath() + "/teacher")) {
			UserModel user = (UserModel) SessionUtil.getInstance().getValue(request, "USER");
			if (user != null) {
				if (user.getRole().equals("teacher")) {
					chain.doFilter(request, response);
				} else {
					response.sendRedirect(request.getContextPath() + "/login");
				}
			}
			else {
				response.sendRedirect(request.getContextPath() + "/login");
			}
		} else if (url.startsWith(request.getContextPath() + "/admin")) {
			UserModel user = (UserModel) SessionUtil.getInstance().getValue(request, "USER");
			if (user != null) {
				if (user.getRole().equals("admin")) {
					chain.doFilter(request, response);
				} else {
					response.sendRedirect(request.getContextPath() + "/login");
				}
			}
			else {
				response.sendRedirect(request.getContextPath() + "/login");
			}
		} else if (url.startsWith(request.getContextPath() + "/student")) {
			UserModel user = (UserModel) SessionUtil.getInstance().getValue(request, "USER");
			if (user != null) {
				if (user.getRole().equals("student")) {
					chain.doFilter(request, response);
				} else {
					response.sendRedirect(request.getContextPath() + "/student");
				}
			}
			else {
				response.sendRedirect(request.getContextPath() + "/login");
			}
		} else {
			chain.doFilter(request, response);
		}
		
	}

	@Override
	public void destroy() {
		
	}

}
