<%@page import="gntp.model2.vo.MemberVO"%>
<%@page import="gntp.model2.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>generate member Info</title>
</head>
<body>
<%
	//id에 대한 멤버 정보를 가져와서 수정화면으로 전달해야 함.
	String id = request.getParameter("id");
	MemberDAO dao = new MemberDAO();
	MemberVO member = dao.selectOne(id);
	request.setAttribute("member", member);
%>
<jsp:forward page="../member/viewMemberInfo.jsp"></jsp:forward>
</body>
</html>