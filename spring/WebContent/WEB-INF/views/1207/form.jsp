<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="/spring/file/upload.do" enctype="multipart/form-data">
		id :<input type="text" name="id" /><br/>
		����:<input type="file" name="save" /> <br/>
			<input type="submit" value="����"/>
	</form>
	


</body>
</html>