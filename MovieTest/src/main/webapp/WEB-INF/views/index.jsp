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
<script>
	$(function(){
		fnList();
	})
	
	function fnList(){
		$.ajax({
			type: 'get',
			url: '${contextPath}/list.json',
			dataType: 'json',
			success: function(resData){
				$('#movieList').empty();
				$.each(resData, function(i, movie){
					let str = '<tr>';
					str += '<td rowspan="6">' + movie.movieNo;
					str += '<tr> <td>' + movie.movieName;
					str += '<tr> <td>' + movie.movieDate;
					str += '<tr> <td>' + movie.movieContent;
					str += '<tr> <td>' + movie.moviePrice;
					$('#movieList').append(str);
				})
			}
			
		})
	}
	
</script>
</head>
<body>
<div>카테고리 메뉴()</div>
<hr>
<div>최신 업데이트 영화</div>
<hr>
<h1>대여가능영화</h1>
<table border="1">

	<tbody id="movieList"></tbody>
</table>


</body>
</html>