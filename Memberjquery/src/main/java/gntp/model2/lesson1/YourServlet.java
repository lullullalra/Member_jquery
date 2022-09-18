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

import org.json.simple.parser.ParseException;

import gntp.model2.dao.MemberDAO;
import gntp.model2.service.MemberService;
import gntp.model2.vo.BookVO;
import gntp.model2.vo.MemberVO;

public class YourServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("생성");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8"); // 무조건 젤 위에 작성
		String command = req.getParameter("command");
		String url = "./member/list.jsp";
		boolean isStop = false;
		MemberDAO dao = new MemberDAO();
		if(command==null) {
			command = "input";
		}
		
		if(command.equals("input")) {
			url = "./member/input.jsp";
		}else if(command.equals("list")) {
			ArrayList<MemberVO> list = null;
			try {
				list = dao.selectAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.setAttribute("list", list);
			
		}else if(command.equals("bookList")) {
			ArrayList<BookVO> bookList = null;
			try {
				bookList = dao.selectAllBook();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.setAttribute("bookList", bookList);
			url = "./member/bookList.jsp";
			
		}else if(command.equals("read")) {
			String id = req.getParameter("id");
			MemberVO member = null;
			try {
				member = dao.selectOne(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.setAttribute("member", member);
			
			url = "./member/viewMemberInfo.jsp";
			
		}else if(command.equals("update")) {
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			
			MemberVO member = new MemberVO(id, pwd, name, email, null);
			try {
				dao.updateOne(member);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			url = "./YourServlet?command=list";
			
		}else if(command.equals("delete")) {
			String id = req.getParameter("id");
			try {
				dao.deleteOne(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			url = "./YourServlet?command=list";
			
		}else if(command.equals("viewJoinPage")) {
			url = "./member/join.jsp";
		}else if(command.equals("join")) {
			//dao에서 입력 요청
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			MemberVO member = new MemberVO(id, pwd, name, email, null);
			try {
				boolean flag = dao.insertDate(member);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			url = "./YourServlet?command=list";
		}else if(command.equals("jquery")) {
			url = "./jquery/jquery_test.jsp";
		}else if(command.equals("ajax")) {
			String userid = req.getParameter("userid");
			System.out.println("ajax --->" +userid);
			//Service -> DAO 요청
			boolean flag = new MemberService().isMember(userid);
			resp.getWriter().print(flag);
			isStop = true;
		}else if(command.equals("json")) {
			String jsonString = req.getParameter("name");
			System.out.println(jsonString);
			MemberService ms = new MemberService();
			try {
				ms.testJsonObject(jsonString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String temp = ms.sendData();
			System.out.println(temp);
			resp.getWriter().print(temp);
			isStop = true;
		}
		
	
		if(!isStop) {
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, resp);
		}
		
		
//		PrintWriter out = resp.getWriter();
//		out.print("<h1>Test Servlet</h1>");
		
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
		System.out.println("소멸");
	}
}
