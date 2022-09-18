<%@page import="gntp.model2.vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="gntp.model2.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	MemberDAO dao = new MemberDAO();
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String pwd = request.getParameter("pwd");
	MemberVO member = new MemberVO(id,pwd,name,email,null);
//업데이트 로직
	boolean flag = dao.updateOne(member);
//전체 조회
	ArrayList<MemberVO> list = null;
	if(flag){
		list = dao.selectAll();
	}
	request.setAttribute("list", list);
%>
<jsp:forward page="../member/list.jsp"></jsp:forward>
</body>
</html>