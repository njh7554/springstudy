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
<!-- 위같이 리소스파일은 header.jsp를 따로 만들어 한곳에 만들어 두는게 필수이다. -->
</head>
<body>

	<!-- EL 사용이 가능한 영역 : pageContext, request, session, application -->
	
	<c:forEach items="${brdList}" var="board">
		<h1>${board.boardNo}</h1>
		<h1>${board.title}</h1>
	</c:forEach>
	
</body>
</html>