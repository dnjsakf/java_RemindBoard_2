<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="my.remind.board2.vo.ContentVO" %>
<%!
	String ctxPath = "/";
	ArrayList<ContentVO> contents = null;
	
	int nextPages = -1;
	int prevPages = -1;
	
	int nowPage = 1;
%>
<%
	ctxPath = request.getContextPath();

	if( request.getParameter("page") != null) {
		nowPage = Integer.valueOf(request.getParameter("page"));
	}

	if( request.getAttribute("contents") != null){
		contents = (ArrayList) request.getAttribute("contents");
	}
	
	if( request.getAttribute("nextPages") != null){
		nextPages = (Integer) request.getAttribute("nextPages");
	}
	
	if( request.getAttribute("prevPages") != null){
		prevPages = (Integer) request.getAttribute("prevPages");
	}
	
	System.out.println("[next] " + nextPages);
	System.out.println("[prev] " + prevPages);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글</title>
</head>
<body>
	<table class="bordered">
		<thead>
			<tr>
				<td class="content-no">No</td>
				<td class="content-title">Title</td>
				<td class="content-writer">Writer</td>
				<td class="content-date">Date</td>
			</tr>
		</thead>
		<tbody>
		<% if( contents != null ) { %>
			<% for(int i = 0; i < contents.size(); i++) { 
				ContentVO content = contents.get(i);
			%>
			<tr class="content-container" content-id="<%= content.getBoardNo() %>">
				<td class="content-no"><%= content.getBoardNo() %></td>
				<td class="content-title"><%= content.getBoardTitle() %></td>
				<td class="content-writer"><%= content.getBoardWriter() %></td>
				<td class="content-date"><%= content.getBoardDate() %></td>
			</tr>
			<% } %>
		<% } %>
		</tbody>
	</table>
	<ul class="page-remote pagination">
		<li>
			<a href="#" class="prev-page-btn" onClick="prevPage(<%= nowPage - 1 %>, <%= nowPage - prevPages %>)">
				<i class="material-icons">chevron_left</i>
			</a>
		</li>
		<% if( prevPages != -1 ) { %>
			<% for(int prevPage = (nowPage - prevPages); prevPage < nowPage; prevPage++) { %>
				<li><a href="#" class="move-page-btn" page="<%= prevPage %>"><%= prevPage %></a></li>
			<% } %>
		<% } %>
		<li><a href="#" class="move-page-btn active" page="<%=nowPage%>"><%= nowPage %></a></li>
		<% if( nextPages > 0 ) { %>
			<% for(int nextPage = (nowPage + 1); nextPage <= (nowPage + nextPages); nextPage++) { %>
				<li><a href="#" class="move-page-btn" page="<%= nextPage %>"><%= nextPage %></a></li>
			<% } %>
		<% } %>
		<li>
			<a href="#" class="next-page-btn" onClick="nextPage(<%= nowPage + 1%>, <%= nowPage + nextPages %>)">
				<i class="material-icons">chevron_right</i>
			</a>
		</li>
	</ul>
	<script src="<%= request.getContextPath()%>/resources/js/board/ListController.js"></script>
</body>
</html>