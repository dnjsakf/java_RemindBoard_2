<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!
	String pageMode = null;
	String pageFileName;
%>
<%
	if( request.getAttribute("mode") != null ){
		pageMode = (String) request.getAttribute("mode"); 
	}
	pageFileName = "ViewMode_"+pageMode+".jsp";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- Header -->
	<header>
		<jsp:include page="component/BoardHeader.jsp"/>
	</header>
	
	<!-- Section -->
	<section>
	<% if( pageMode != null ) { %>
		<jsp:include page="<%= pageFileName %>"/>
	<% } else { %>
		None Page File
	<% } %>
	</section>
	<!-- Footer -->
	<footer>
		<a>License</a>	
	</footer>
</body>
</html>