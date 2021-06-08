<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<table border='1'>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>salary</th>
		</tr>
		<c:forEach items="${listemp}" var="employee">
		<tr>
			<td>${ employee.id}</td>
			<td>${ employee.name}</td>
			<td>${ employee.salary}</td>
		</tr>
		</c:forEach>
	</table>
	<div>
		<ul class="pagination">
		<c:if test="${numberpage ==1}">
			<li class="disabled"><a href="Forward?pageid=${numberpage-1}">&laquo;</a></li>
			<li><a href="Forward?pageid=1">1</a></li>
			<li><a href="Forward?pageid=2">2</a></li>
			<li><a href="Forward?pageid=${numberpage+1}">&raquo;</a></li>
			</c:if>
			<c:if test="${numberpage == maxpageid}">
			<li ><a href="Forward?pageid=${numberpage-1}">&laquo;</a></li>
			<li><a href="Forward?pageid=1">1</a></li>
			<li><a href="Forward?pageid=2">2</a></li>
			<li class="disabled"><a href="Forward?pageid=${numberpage+1}">&raquo;</a></li>
			</c:if>
			<c:if test="${numberpage > 1 && numberpage<maxpageid}">
			<li ><a href="Forward?pageid=${numberpage-1}">&laquo;</a></li>
			<li><a href="Forward?pageid=1">1</a></li>
			<li><a href="Forward?pageid=2">2</a></li>
			<li><a href="Forward?pageid=${numberpage+1}">&raquo;</a></li>
			</c:if>
			
		</ul>
	</div>

</body>
</html>