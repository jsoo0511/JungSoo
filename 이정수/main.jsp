<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메인 페이지</h1>
	<%
		if(session.getAttribute("IsLogin") != null) {
	%>
			반갑습니다. <%=session.getAttribute("IsLogin") %>님
	<%
		} else {
	%>
			<form method="post" action="Login">
				<%
					if(session.getAttribute("LoginError") != null) {
				%>
						로그인하여 주세요
				<%
					}
					session.removeAttribute("LoginError");
				%>
				<table>
					<tr>
						<td>ID</td>
						<td><input type="text" name="id" id="id"> </td>
					</tr>
					
					<tr>
						<td>PASSWORD</td>
						<td><input type="password" name="pass" id="pass"> </td>
					</tr>
				</table>
				<input type="submit" value="LOGIN">
			</form>
			
	<%
		}
	%>
	
	<br><br>
	<a href="addproduct.jsp">상품 등록</a>
	<a href="#">상품 목록</a>
	<a href="recentproduct.jsp">마지막 등록한 상품</a>
</body>
</html>