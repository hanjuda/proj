package action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JoinSignUpAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		MemberDao dao = new MemberDao();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		if(dao.signUp(new MemberDto(id,pw,name,0))) {
			RequestDispatcher rd = request.getRequestDispatcher("signIn.jsp");
			request.setAttribute("fail", "가입되었습니다. 로그인 해 주세요.");
			rd.forward(request, response);
		}else {
			response.sendRedirect("signUp.jsp");
		}
	}

}
