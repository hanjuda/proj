package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BuyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDao dao = new MemberDao();
		int minus_point = Integer.parseInt(request.getParameter("minus_point"));
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		int point = dao.userInfo(id).getPoint();
		dao.minusPoint(id, point, minus_point);
		point = dao.userInfo(id).getPoint();
		
		PrintWriter out = response.getWriter();
		out.print(point);
		
		
	}

}
