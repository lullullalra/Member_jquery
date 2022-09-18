package gntp.model2.lesson1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gntp.model2.dao.MemberDAO;
import gntp.model2.vo.MemberVO;



public class MyServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		resp.setContentType("text/html; charset=UTF-8");
		String command = req.getParameter("command");
//		PrintWriter out = resp.getWriter();
//		out.print("<h1>Hi! Servlet~</h1>");
//		out.print("<h1>안녕! Servlet~</h1>");
		String url = "./member/list.jsp";
		MemberDAO dao = new MemberDAO();
		req.setCharacterEncoding("UTF-8");
		if(command.equals("list")) {
			/////////////////// 전체 조회 //////////////////////////
			ArrayList<MemberVO> list = null;
			try {
				list = dao.selectAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.setAttribute("list", list);
			//resp.sendRedirect("./member/list.jsp");
			/////////////////////////////////////////////////
		} else if(command.equals("read")) {
			///// 개별 회원 정보 조회 //////////////////
			String id = req.getParameter("id");
			   //
			   //dao = new MemberDAO();
			   MemberVO member = null;
			try {
				member = dao.selectOne(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   req.setAttribute("member", member);
			   // ./member/viewMemberInfo.jsp" 
			   url = "./member/viewMemberInfo.jsp";
		/////////////////////////////////////////////////
		}else if(command.equals("update")) {
			///////회원 정보 수정///////////////////////////
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String pwd = req.getParameter("pwd");
			MemberVO member = new MemberVO(id,pwd,name,email,null);
			try {
				boolean flag = dao.updateOne(member);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			url = "./MyServlet?command=list";
		}
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		doGet(req, resp);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy");
	}
}
