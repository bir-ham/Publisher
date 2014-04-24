<%@ include file="top.inc"%>

<%@ include file="middle.inc"%>

<%
	String message = (String) request.getAttribute("message");
	if (message != null) {
		out.println("<p style='color: red; margin-top 40px'>" + message + "</p>");
	}
%>
<%@ include file="bottom.inc"%>