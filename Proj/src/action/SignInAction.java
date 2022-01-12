package action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignInAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDao dao = new MemberDao();
		MemberDto dto = null;
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		System.out.println("들어옴???????????");
		if(dao.signIn(id, pw)){
			if(id.equals("admin")) {
				rd = request.getRequestDispatcher("Controller?command=manager");
				session.setAttribute("id", id);
				rd.forward(request, response);
			}else {
				rd = request.getRequestDispatcher("Controller?command=main");
				session.setAttribute("id", id);
				rd.forward(request, response);
			}
			
		}else {
			rd = request.getRequestDispatcher("signIn.jsp");
			request.setAttribute("fail", "아이디/비밀번호를 다시 확인하세요");
			rd.forward(request, response);
		}
		
		
	}

}
