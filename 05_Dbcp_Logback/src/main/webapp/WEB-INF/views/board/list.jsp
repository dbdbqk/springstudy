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
	function fnAdd(){
		location.href='${contextPath}/board/write.do';
	}
	function fnDelete(event){
		if(confirm('삭제할까요?') == false){
			event.preventDefault();
			location.href='${contextPath}/board/list.do';
		}
	}
	
</script>
</head>
<body>
	<div>
		<input type="button" id="add" name="add" value="게시글 작성" onclick=fnAdd()>
		<table border="1">
			<thead>
				<tr>
					<td>제목</td>
					<td>작성자</td>
					<td colspan="2">작성일</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boardList}" var="b">
					<tr>
						<td>${b.title}</td>
						<td>${b.writer}</td>
						<td>${b.created_at}</td>
						<td>
							<form method="post" action="${contextPath}/board/remove.do">
								<input type="hidden" name="board_no" value="${b.board_no}">
								<input type="submit" value="삭제" onclick=fnDelete()>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
</body>
</html>