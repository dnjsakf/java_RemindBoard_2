<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="my.remind.board2.vo.ContentVO" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.util.Date" %>
<%!
	int nowPage = 1;
	ContentVO content = null;
	String ctxPath;
	
	DateFormat df = DateFormat.getDateInstance();
%>
<%
	ctxPath = request.getContextPath();
	// 현재 페이지
	if( request.getParameter("page") != null ){
		nowPage = Integer.valueOf(request.getParameter("page"));
	}
	// 보여줄 콘텐츠 내용
	if( request.getAttribute("content") != null ){
		content = (ContentVO) request.getAttribute("content");
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="<%= ctxPath %>/resources/css/board/comment.css"></link>
</head>
<body>
	<% if( content != null)  { %>
	<div class="row">
		<!-- 제목 -->
		<div class="input-field col s12">
			<input 	id="title" 
					class="info-title" 
					name="title"
					value="<%= content.getBoardTitle() %>" 
					readonly>
			<label for="title">제목</label>
		</div>
		<!-- 작성자 -->
		<div class="input-field col s6">
			<input 	id="writer"
					class="info-writer"
					value="<%= content.getBoardWriter() %>"
					readonly>
			<label for="writer">작성자</label>
		</div>
		<!-- 작성일 -->
		<div class="input-field col s6">
			<input 	id="date"
					class="info-date"
					value="<%= content.getBoardDate() %>"
					readonly>
			<label for="date">작성일</label>
		</div>
		<!-- 내용 -->
		<div class="input-field col s12">
			<textarea id="content" class="materialize-textarea" readonly><%= content.getBoardContent() %></textarea>
			<label for="content">내용</label>
		</div>
		
		<div class="remote col s6">
			<a>목록으로</a>
			<a>수정</a>
			<a>삭제</a>
		</div>
	</div>

	<!-- Comments Component : AJAX -->
	<!-- 댓글목록 -->
	<div id="comment-list">
		<!-- ajax data -->
	</div>
	
	<!-- 댓글작성: AJAX로 처리하자 -->
	<div id="comment-write" class="comment-item">
		<div class="row">
			<div class="input-field col s4">
				<input id="comment-input-writer" type="text" class="comment-input writer" name="writer">
				<label for="comment-input-writer">작성자</label>
			</div>
			<div class="input-field col s4">
				<input id="comment-input-password" type="password" class="comment-input password" name="password">
				<label for="comment-input-password">비밀번호</label>
			</div>
			<div class="input-field col s4">
				<input id="comment-input-date" type="text" class="comment-input date" name="date" value="<%= df.format(new Date()) %>" readonly>
				<label for="comment-input-date" class="active">작성일</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<textarea id="comment-input-comment" class="comment-input comment materialize-textarea" name="comment"></textarea>
				<label for="comment-input-comment">내용</label>
			</div>
		</div>
		<div class="row" style="text-align: right; padding-right: 30px;">
			<a href="#" onClick="saveComment()">저장</a>
		</div>
	</div>
		
	<% } %>
	<script src="<%= ctxPath %>/resources/js/board/ViewController.js"></script>
</body>
</html>