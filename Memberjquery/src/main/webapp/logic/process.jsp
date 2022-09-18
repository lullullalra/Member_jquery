<%@page import="gntp.model2.vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="gntp.model2.dao.MemberDAO"%>
<%@page import="gntp.model2.util.ConnectionManager"%>
<%@page import="java.sql.Connection"%>
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
	//test
	/*
	Connection con = ConnectionManager.getConnection();
	if(con!=null){
		System.out.println("Success");
		con.close();
	}else{
		System.out.println("fail");
	}
	*/
%>
<%!



	public void jspInit(){
		System.out.println("jsp Init");
	}

	public void jspDestroy(){
		System.out.println("jsp Destroy");
	}
%>

<%
	//login process
	System.out.println("logic");
	MemberDAO dao = new MemberDAO();
	ArrayList<MemberVO> list = dao.selectAll();
	request.setAttribute("list", list);
%>
<jsp:forward page="../member/list.jsp"></jsp:forward>
</body>
</html>