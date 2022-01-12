package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class MemberDao {
	Connection conn = DBConnection.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public boolean signIn(String id,String pw) {
		String sql = "SELECT * FROM member where id=? and pw=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			rs.close();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean signUp(MemberDto dto) {
		String sql = "INSERT INTO member(id,pw,name,point) values(?,?,?,1000)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			int r = pstmt.executeUpdate();
			if(r==1) {
				return true;
			}
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	//유저정보
	public MemberDto userInfo(String user_id) {
		MemberDto dto = null;
		String sql = "SELECT * FROM member where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				int point = rs.getInt("point");
				dto = new MemberDto(id,pw,name,point);
			}
			rs.close();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	
	
	
	//포인트 1000점 추가!
	public void addPoint(String id,int point) {
		String sql = "UPDATE MEMBER set point = ? where id= ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, point+1000);
			pstmt.setString(2,id);
			pstmt.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void minusPoint(String id,int point,int productpoint) {
		if(point - productpoint<0) {
			return;
		}
		String sql = "UPDATE MEMBER set point = ? where id= ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, point-productpoint);
			pstmt.setString(2,id);
			pstmt.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MemberDto> userAll() {
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		String sql = "SELECT * FROM member";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				int point = rs.getInt("point");
				list.add(new MemberDto(id,pw,name,point));
			}
			rs.close();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void deleteUser(String id) {
		String sql = "delete from member where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public JSONArray ajaxUser() {
		JSONArray jarr = new JSONArray();
		String sql = "select * FROM member";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				JSONObject jobj  = new JSONObject();
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				int point = rs.getInt("point");
				jobj.put("id", id);
				jobj.put("pw", pw);
				jobj.put("name", name);
				jobj.put("point", point);
				jarr.add(jobj);
			}
			rs.close();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return jarr;
	}
	
	public void updateMember(MemberDto dto) {
		String sql = "UPDATE MEMBER set pw = ? ,name = ?,point = ? where id= ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dto.getPw());
			pstmt.setString(2,dto.getName());
			pstmt.setInt(3,dto.getPoint());
			pstmt.setString(4,dto.getId());
			pstmt.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}