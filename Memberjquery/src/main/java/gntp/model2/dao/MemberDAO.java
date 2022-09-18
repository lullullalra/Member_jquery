package gntp.model2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gntp.model2.util.ConnectionManager;
import gntp.model2.vo.BookVO;
import gntp.model2.vo.MemberVO;

public class MemberDAO {
	
	//전체 조회
	public ArrayList<MemberVO> selectAll() throws SQLException{
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		String sql = "select * from member";
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		MemberVO member = null;
		while(rs.next()) {
			member = new MemberVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getTimestamp(5));
			list.add(member);
		}
		ConnectionManager.closeConnection(rs, pstmt, con);
		return list;
	}
	
	public ArrayList<BookVO> selectAllBook() throws SQLException{
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		String sql = "select * from book";
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		BookVO book = null;
		while(rs.next()) {
			book = new BookVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getTimestamp(5));
			list.add(book);
		}
		ConnectionManager.closeConnection(rs, pstmt, con);
		return list;
	}
	
	//조건 조회
	public MemberVO selectOne(String id) throws SQLException {
		MemberVO member = null;
		Connection con = ConnectionManager.getConnection();
		String sql = "select * from member where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			member = new MemberVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getTimestamp(5));
		}
		ConnectionManager.closeConnection(rs, pstmt, con);		
		return member;
	}
	
	//회원 정보 수정
	public boolean updateOne(MemberVO member) throws SQLException {
		boolean flag = false;
		String sql = "update member set pwd = ?, name = ?, email = ? where id = ?";
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, member.getPwd());
		pstmt.setString(2, member.getName());
		pstmt.setString(3, member.getEmail());
		pstmt.setString(4, member.getId());
		int affectedCount = pstmt.executeUpdate();
		if(affectedCount>0) {
			flag = true;
		}
		ConnectionManager.closeConnection(null, pstmt, con);
		return flag;
	}
	
	
	public boolean deleteOne(String id) throws SQLException {
		boolean flag = false;
		String sql = "delete from member where id = ? ";
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		int affectedCount = pstmt.executeUpdate();
		if(affectedCount>0) {
			flag = true;
		}
		ConnectionManager.closeConnection(null, pstmt, con);
		return flag;
	}
	
	public boolean insertDate(MemberVO member) throws SQLException{
		boolean flag = false;
		String sql = "insert into member values(?,?,?,?,now())";
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPwd());
		pstmt.setString(3, member.getName());
		pstmt.setString(4, member.getEmail());
		int affectedCount = pstmt.executeUpdate();
		if(affectedCount>0) {
			flag = true;
		}
		ConnectionManager.closeConnection(null, pstmt, con);
		return flag;
	}
	
	
	
}
