package action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDto dto = null;
		MemberDao dao = new MemberDao();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		dto = dao.userInfo(id);
		
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
		request.setAttribute("userInfo", dto);
		rd.forward(request, response);
	}

}
