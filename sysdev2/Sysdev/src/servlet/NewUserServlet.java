package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NewUserLogic;
import model.User;

@WebServlet("/NewUserServlet")
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewUserServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("チェックポイント１");

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/NewUser.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("アカウント作成");
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("user_name");
		String id = request.getParameter("user_id");
		String pass = request.getParameter("password");

		System.out.println(name);
		System.out.println(id);
		System.out.println(pass);

		// if (Util.validateId(id) && Util.validatePassword(pass)) {//文字数チェック入れる必要あり

		User user = new User(id, name, pass);

		System.out.println(user);

		NewUserLogic newUserLogic = new NewUserLogic();

		newUserLogic.insert(user);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Login.jsp");
		dispatcher.forward(request, response);
		// }
		doGet(request, response);
	}

}