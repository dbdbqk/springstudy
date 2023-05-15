<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/lib/jquery-3.6.4.min.js"></script>
<script src="${contextPath}/resources/summernote-0.8.18-dist/summernote-lite.min.js"></script>
<script src="${contextPath}/resources/summernote-0.8.18-dist/lang/summernote-ko-KR.min"></script>
<link rel="stylesheet" href="${contextPath}/resources/summernote-0.8.18-dist/summernote-lite.min.css">
<script>
	function fnRemove(){
		if(confirm('삭제할꺼야?')){
		location.href="${contextPath}/board/remove.do?board_no=${board.board_no}"
		}
	}
	function fnList(){
		location.href="${contextPath}/board/list.do";
	}
	
</script>
</head>
<body>
	<h1>${board.board_no}번 게시글 상세보기</h1>
	<div>제목 : ${board.title}</div>
	<div>작성자 : ${board.writer}</div>
	<div>작성일 : ${board.created_at}</div>
	<div>수정일 : ${board.modified_at}</div>
	<div>${board.content}</div>
	<div>
		<form method="post" action="${contextPath}/board/edit.do">
		<input type="hidden" name="title" value="${board.title}">
		<input type="hidden" name="board_no" value="${board.board_no}">
		<input type="hidden" name="content" value="${board.content}">
		<button>편집</button>
		</form>
		<input type="button" value="삭제" onClick="fnRemove()">
		<input type="button" value="목록" onClick="fnList()">
	</div>

</body>
</html>