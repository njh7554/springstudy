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
	function fnList() {
		location.href = '${contextPath}/upload/list.do';
	}
	function fnFileCheck(vThis){ // 첨부 input에 onchange="functionCheck()"를 주어서 호출해준다. 
		$('#files').on('change', function(){
			// 최대 크기 10MB
			let maxSize = 1024 * 1024 * 10;
			
			// 첨부된 파일 목록
			let files = vThis.files;
			
			// 첨부된 파일 순회(크기 체크 + 첨부된 파일명 표시)
			$('#fileList').empty();
			$.each(files, function(i, file){
				
				// 크기 체크
				if(file.size > maxSize){
					alert('각 첨부파일의 최대 크기는 10MB입니다.;')
					$(vThis).val(''); // 첨부된 파일을 모두 지운다.
					return;
				}
				
				// 첨부된 파일명 표시
				$('#fileList').append('<div>' + file.name + '</div>');
				
		})
	}
</script>
</head>
<body>

	<div>
		<h1>UPLOAD 게시글 작성하기</h1>
		<form method="post" enctype="multipart/form-data" action="${contextPath}/upload/add.do">
			<div>
				<label for="uploadTitle">제목</label>
				<input type="text" id="uploadTitle" name="uploadTitle">
			</div>
			<div>
				<label for="uploadContent">내용</label><br>
				<textarea id="uploadContent" name="uploadContent" rows="5" cols="30"></textarea>
			</div>
			<div>
				<label for="files">첨부</label><br>
				<input type="file" id="files" name="files" multiple="multiple" onchange="functionCheck(this)">
				<div id="fileList">첨부파일의 목록이 이곳에 표시됩니다.</div>
 			</div>
			<div>
				<button>작성완료</button>
				<input type="button" value="목록" onclick="fnList()">
			</div>
		</form>
	</div>
	
</body>
</html>