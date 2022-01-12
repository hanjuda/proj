package action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdataAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDao dao = new MemberDao();
		String id = request.getParameter("id");
		MemberDto dto = dao.userInfo(id);
		
		RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
		request.setAttribute("user", dto);
		rd.forward(request, response);
		
	}

}
