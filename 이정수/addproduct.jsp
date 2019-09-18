
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if(session.getAttribute("IsLogin") == null) {
			session.setAttribute("LoginError", "LoginError");
			response.sendRedirect("main.jsp");
		} else {
	%>
			<h1>상품 등록 페이지</h1>
			<form action="AddProduct" method="post">
				<table>
					<tr>
						<td>상품번호</td>
						<td><input type="text" name="number"> </td>
					</tr>
					
					<tr>
						<td>상품명</td>
						<td><input type="text" name="name"> </td>
					</tr>
					
					<tr>
						<td>상품가격</td>
						<td><input type="text" name="price"> </td>
					</tr>
					
					<tr>
						<td>상품설명</td>
						<td><input type="text" name="info"> </td>
					</tr>
				</table>
				<input type="submit" value="등록">
			</form>
	<%
		}
	%>
</body>
</html>