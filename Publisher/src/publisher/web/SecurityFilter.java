package publisher.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecurityFilter extends ParentServlet implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		logger.debug("doFilter()");

		HttpServletResponse resp = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		String servletPath = req.getServletPath();

		// Allow access to login functionality.
		if (servletPath.equals("/login")) {
			chain.doFilter(req, resp);
			return;
		}

		// Allow access to news feed.
		if (servletPath.equals("/news.rss")) {
			chain.doFilter(req, resp);
			return;
		}

		// Allow access to web service.
	      if (servletPath.equals("/publish"))
	      {
	         chain.doFilter(req, resp);
	         return;
	      }
	      
		// All other functionality requires authentication.
		HttpSession session = req.getSession();
		Long userId = (Long) session.getAttribute("userId");

		if (userId != null) {
			// User is logged in.
			chain.doFilter(req, resp);
			return;
		}

		// Request is not authorized.
		resp.sendRedirect("login");

	}

}
