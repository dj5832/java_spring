<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	alert('${id}님의 계정을 ${msg}했습니다.');
	location.href="detail.do?id=${id}";	
</script>