package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.sendRedirect("signUp.jsp");
	}

}
