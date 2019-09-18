<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "hw.dto.Product" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>마지막 등록한 상품</h1>
	<%
		if(session.getAttribute("IsLogin") == null) {
			session.setAttribute("LoginError", "LoginError");
			response.sendRedirect("main.jsp");
		} else { 
			Product product = null;
			Cookie cookies[] = request.getCookies();
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("recentcookie")) {
					product = (Product)session.getAttribute(cookie.getValue());
					break;
				}
			}
			
			if(product == null) {
	%>
			<p>최근에 등록한 상품이 존재하지 않습니다.</p>
	<%
			} else {
			
	%>
			<table>
				<tr>
					<td>상품번호</td>
					<td><%=product.getNumber()%> </td>
				</tr>
				
				<tr>
					<td>상품명</td>
					<td><%=product.getName()%> </td>
				</tr>
				
				<tr>
					<td>상품가격</td>
					<td><%=product.getPrice()%> </td>
				</tr>
				
				<tr>
					<td>상품설명</td>
					<td><%=product.getInfo()%> </td>
				</tr>
			</table>
	<%
			}
		}
	%>
	
	<a href="#">상품 수정</a>
	<a href="#">상품 삭제</a>
	<a href="#">상품 목록</a>
</body>
</html>