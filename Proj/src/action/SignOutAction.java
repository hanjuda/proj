package action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignOutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("signIn.jsp");
		request.setAttribute("fail", "로그아웃 되었습니다.");
		rd.forward(request, response);
	}

}
