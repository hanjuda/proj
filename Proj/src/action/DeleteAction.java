package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDao dao = new MemberDao();
		String id = request.getParameter("id");
		dao.deleteUser(id);
		JSONArray jar = dao.ajaxUser();
		PrintWriter out = response.getWriter();
		out.print(jar);
		
	}

}
