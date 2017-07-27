<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	Integer resultado = null;
	switch (request.getParameter("operacion")) {
	case "suma":
		resultado = Integer.parseInt(request.getParameter("numero1"))
				+ Integer.parseInt(request.getParameter("numero2"));
		break;
	case "resta":
		resultado = Integer.parseInt(request.getParameter("numero1"))
				- Integer.parseInt(request.getParameter("numero2"));
		break;
	case "multiplicacion":
		resultado = Integer.parseInt(request.getParameter("numero1"))
				* Integer.parseInt(request.getParameter("numero2"));
		break;
	case "division":
		resultado = Integer.parseInt(request.getParameter("numero1"))
				/ Integer.parseInt(request.getParameter("numero2"));
		break;
	}
%>
El resultado es: <%=resultado%>