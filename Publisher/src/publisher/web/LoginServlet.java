package publisher.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import publisher.data.SecureDigester;
import publisher.data.User;
import publisher.data.UserDAO;

public class LoginServlet extends ParentServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		logger.debug("doGet()");
		jsp.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		logger.debug("doPost()");

		String username = req.getParameter("username");
		User user = new UserDAO().findByUsername(username);

		if (user == null) {
			logger.debug("authentication failed: username doesn't exist!");
			req.setAttribute("message", "Authentication failed.");
			jsp.forward(req, resp);
			return;
		}

		String password = req.getParameter("password");
		if (password == null) {
			logger.debug("authentication failed: no password");
			req.setAttribute("message", "Authentication failed.");
			jsp.forward(req, resp);
			return;
		}
		
		String passwordDigest = SecureDigester.digest(password);
		if (!user.getPassword().equals(passwordDigest)) {
			logger.debug("authentication failed: bad password");
			req.setAttribute("message", "Authentication failed.");
			jsp.forward(req, resp);
			return;
		}

		HttpSession session = req.getSession();
		Long userId = user.getId();
		session.setAttribute("userId", userId);
		logger.debug("authenticated");
		resp.sendRedirect("home");
	}

}
