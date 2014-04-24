package publisher.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends ParentServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		logger.debug("doGet()");

		HttpSession session = req.getSession();
		session.invalidate();
		resp.sendRedirect("login");
	}

}
