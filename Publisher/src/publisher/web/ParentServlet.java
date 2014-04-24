package publisher.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

public class ParentServlet extends HttpServlet {
	
	protected Logger logger = Logger.getLogger(this.getClass());
	protected RequestDispatcher jsp;
	protected RequestDispatcher jspErr;

	@Override
	public void init(ServletConfig config) throws ServletException {		
		ServletContext context = config.getServletContext();
		
		// Set the rest JSP pages
		String initParam = config.getInitParameter("jsp");
		jsp = context.getRequestDispatcher(initParam);
		
		// Set JSP error page
		String initParamErr = config.getInitParameter("jspErr");
		jspErr = context.getRequestDispatcher(initParamErr);
	}
	
	/**
	public void dispatch(HttpServletRequest request,
			HttpServletResponse response, String key, Object o, String page)
			throws ServletException, IOException {
		request.setAttribute(key, o);
		RequestDispatcher dis = request.getRequestDispatcher(page);
		dis.forward(request, response);
	}
*/
}
