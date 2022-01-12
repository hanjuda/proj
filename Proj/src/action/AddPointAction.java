package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddPointAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDao dao = new MemberDao();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		int point = dao.userInfo(id).getPoint();
		dao.addPoint(id,point);
		response.sendRedirect("http://www.koreaisacademy.com");
	}

}
