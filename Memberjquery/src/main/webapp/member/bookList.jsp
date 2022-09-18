<%@page import="java.util.Date"%>
<%@page import="gntp.model2.util.DateTimeService"%>
<%@page import="gntp.model2.vo.BookVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Book List</h1>
<%
	request.setCharacterEncoding("UTF-8");
	ArrayList<BookVO> bookList = (ArrayList<BookVO>)request.getAttribute("bookList");
	for(BookVO book : bookList){
		
	}
%>
<table>
	<tr><th>도서 번호</th><th>도서명</th><th>저자</th><th>가격</th><th>구입일</th><th>대출</th></tr>
<% for(BookVO book : bookList){ %>
	<tr>
		<td><%=book.getBookNo() %></td>
		<td><%=book.getBookName() %></td>
		<td><%=book.getAuthor() %></td>
		<td><%=book.getPrice() %></td>
		<td><%=DateTimeService.getDateTime(DateTimeService.DATE_ONLY, new Date(book.getBuyDate().getTime()))%></td>
		<td><a><button>대출</button></a></td>
	</tr>
<%} %>
</table>
</body>
</html>