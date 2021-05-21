package userTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/modifyUserServlet")
public class ModifyUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModifyUserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		
		UserVO vo = new UserVO();
		
		String userId = request.getParameter("userID");
		String name = request.getParameter("name");
		String userPass = request.getParameter("userPass");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		
		vo.setUserID(userId);
		vo.setName(name);
		vo.setUserPass(userPass);
		vo.setPhone(phone);
		vo.setGender(gender);
		
		System.out.println(vo.toString());

		UserDAO dao = new UserDAO();
		int userUpdateResultCount = dao.updateUser(vo);
				
		System.out.println("update query result : "+ userUpdateResultCount);
		response.getWriter().print(userUpdateResultCount);
		
		response.sendRedirect("/UserProj/userInfo.html");
		
	}

}
