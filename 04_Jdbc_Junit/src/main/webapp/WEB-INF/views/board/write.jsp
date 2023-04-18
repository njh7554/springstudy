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
<script src="${contextPath}/resources/summernote-0.8.18-dist/summernote-lite.min.js"></script> <!-- lite는 압축버전인거 말고는 다른점이 없다, 부트스트랩 쓸거면 충돌이 좀 있어서 그런지 lite버전이 좋다고 한다. -->	
<script src="${contextPath}/resources/summernote-0.8.18-dist/lang/summernote-ko-KR.min.js"></script> 
<link rel="stylesheet" href="${contextPath}/resources/summernote-0.8.18-dist/summernote-lite.min.css">
<!-- 위같이 리소스파일은 header.jsp를 따로 만들어 한곳에 만들어 두는게 필수이다. -->
<script>
	function fnList(){
		location.href = '${contextPath}/board/list.do';
	}
	
	$(function(){
		$('#content').summernote({
			width: 640,
			height: 480,
			lang: 'ko-KR',
			toolbar: [
					  ['style', ['bold', 'italic', 'underline', 'clear']],
					  ['font', ['strikethrough', 'superscript', 'subscript']],
					  ['color', ['color']],
					  ['fontname', ['fontname']],
					  ['para', ['ul', 'ol', 'paragraph']],
					  ['table', ['table']],
					  ['insert', ['link', 'picture', 'video']],
					  ['view', ['fullscreen', 'codeview', 'help']],
			]
		})
	})
	
</script>
</head>
<body>

	<div>
		<h1>작성화면</h1>
		<form method="post" action="${contextPath}/board/add.do">
			<div>
				<label for="title">제목</label>
				<input type="text" id="title" name="title">
			</div>
			<div>
				<label for="writer">작성자</label>
				<input type="text" id="writer" name="writer">
			</div>
			<div>
				<div><label for="content">내용</label></div>
				<textarea id="content" name="content"></textarea> <!-- summernote 편집기로 바뀌는 textarea -->
			</div>
			<div>
				<button>작성완료</button>
				<input type="button" value="목록" onclick="fnList()">
			</div>
		</form>
	</div>

</body>
</html>