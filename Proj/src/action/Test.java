package action;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		//ȸ������!
		//System.out.println(dao.signUp(new MemberDto("hj","1234","����",0)));
		
		//�α���!
		//System.out.println(dao.signIn("hj", "1234"));
		
		//����Ŭ��������Ʈ õ�� �����ִ°�
		//dao.addPoint("hj",dao.userInfo("hj").getPoint());
		
		//������������ ����Ʈ �������°�
		//System.out.println(dao.userInfo("hj").getPoint());
		
		//����Ʈ���� ���ִ°�
		//dao.minusPoint("hj", dao.userInfo("hj").getPoint(), 1000);
		
		//���� ����Ʈ
		//System.out.println(dao.userInfo("hj").getPoint());
		
		//����Ʈ���� ���ִ°�
		//dao.minusPoint("hj", dao.userInfo("hj").getPoint(), 10000);
		
		//System.out.println(dao.userInfo("hj").getPoint());
		
		
		//��ü ȸ�� ��ȸ
		/*for(int i=0;i<dao.userAll().size();i++) {
			System.out.print(dao.userAll().get(i).getId() + " ");
			System.out.print(dao.userAll().get(i).getPw() + " ");
			System.out.print(dao.userAll().get(i).getName() + " ");
			System.out.print(dao.userAll().get(i).getPoint() + " ");
			System.out.println();
		}
		//ȸ�� ����
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
