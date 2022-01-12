package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResultUpdataAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDao dao = new MemberDao();
		MemberDto dto = null;
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		int point = Integer.parseInt(request.getParameter("point"));
		
		dao.updateMember(new MemberDto(id,pw,name,point));
		request.getRequestDispatcher("Controller?command=manager").forward(request, response);
		
		
	}

}
