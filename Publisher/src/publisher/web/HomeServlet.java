package publisher.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends ParentServlet {
	
	/**
	// If this code block is used, then this servlet doesn't need
	// to extend the ParentServlet, instead extends HttpServlet, and 
	// the initParam element in the web.xml can be removed  
	private Logger logger = Logger.getLogger(this.getClass());
	private RequestDispatcher jsp;

	public void init(ServletConfig config) throws ServletException {
		
		ServletContext context = config.getServletContext();
		jsp = context.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
	}
	*/
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		logger.debug("doGet()");
		jsp.forward(req, resp);
	}

}
