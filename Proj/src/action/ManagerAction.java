package action;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManagerAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDao dao = new MemberDao();
		ArrayList<MemberDto> list = dao.userAll();
		RequestDispatcher rd = request.getRequestDispatcher("manager.jsp");
		request.setAttribute("list", list);
		rd.forward(request, response);
		
	}

}
