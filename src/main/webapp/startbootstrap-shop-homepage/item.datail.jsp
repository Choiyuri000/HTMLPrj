<%@page import="co.yedam.shop.ShopDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String itemNo = request.getParameter("item_no"); //001
	ShopDAO dao = new ShopDAO();
	Item searchItem = dao.getItemNo(itemNo);
	out.print("<h1>" + searchItem.getItemNo() + "</h1>");
	out.print("<h1>" + searchItem.getItemName() + "</h1>");
	out.print("<img src= 'href='../image/'" + searchItem.getImage() + "'>");
	%>
</body>
</html>