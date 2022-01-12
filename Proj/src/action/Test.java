package action;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		//회원가입!
		//System.out.println(dao.signUp(new MemberDto("hj","1234","한주",0)));
		
		//로그인!
		//System.out.println(dao.signIn("hj", "1234"));
		
		//광고클릭시포인트 천점 더해주는거
		//dao.addPoint("hj",dao.userInfo("hj").getPoint());
		
		//유저정보에서 포인트 가져오는거
		//System.out.println(dao.userInfo("hj").getPoint());
		
		//포인트에서 빼주는거
		//dao.minusPoint("hj", dao.userInfo("hj").getPoint(), 1000);
		
		//유저 포인트
		//System.out.println(dao.userInfo("hj").getPoint());
		
		//포인트에서 빼주는거
		//dao.minusPoint("hj", dao.userInfo("hj").getPoint(), 10000);
		
		//System.out.println(dao.userInfo("hj").getPoint());
		
		
		//전체 회원 조회
		/*for(int i=0;i<dao.userAll().size();i++) {
			System.out.print(dao.userAll().get(i).getId() + " ");
			System.out.print(dao.userAll().get(i).getPw() + " ");
			System.out.print(dao.userAll().get(i).getName() + " ");
			System.out.print(dao.userAll().get(i).getPoint() + " ");
			System.out.println();
		}
		//회원 삭제
		dao.deleteUser("as");
		
		for(int i=0;i<dao.userAll().size();i++) {
			System.out.print(dao.userAll().get(i).getId() + " ");
			System.out.print(dao.userAll().get(i).getPw() + " ");
			System.out.print(dao.userAll().get(i).getName() + " ");
			System.out.print(dao.userAll().get(i).getPoint() + " ");
			System.out.println();
		}*/
		
		
		
		
	}
}
