<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>송금결과 페이지<br>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<table border="1">
		<caption><font size="5">결과 페이지</font></caption>
		
			<tr>
				<td>사용자 송금 성공 여부 : ${sendmoney[0] }</td>
				<td>시스템 송금 성공 여부 : ${sendmoney[1] }</td>
				<td>밸런스 송금 성공 여부 : ${sendmoney[2] }</td>
				
				<td>잔고 : ${sendre.money }원입니다</td>
			</tr>
		
	</table>
	[<a href="main">메인 페이지</a>]

</body>
</html>