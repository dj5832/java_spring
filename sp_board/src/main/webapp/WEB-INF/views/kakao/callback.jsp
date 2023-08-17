<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		console.log('${userInfo}')
		let name = '${userInfo.nickname}';
		let email = '${userInfo.email}';
		$("#name").html("환영합니다."+ name +" 님");
		$("#email").html(email);
	  });
</script>
    
<body>
	<h2 style="text-align: center" id="name"></h2>
	<h4 style="text-align: center" id="email"></h4>
</body>
</html>