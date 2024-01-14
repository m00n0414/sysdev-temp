package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;
//import com.mysql.cj.util.Util;
import util.Util;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String forward = null;//ローカル変数"forward"を作成

		HttpSession session = request.getSession();

		if (session.getAttribute("LoginUser") == null) {
			System.out.println(session.getAttribute("LoginUser"));//debug

			//未ログイン処理
			forward = "Login.jsp";

			forward = "WEB-INF/jsp/" + forward;

			System.out.println("未ログインのため Login.jsp へフォワード");//debug

			//追加箇所ここから
			//フォワード処理
			RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
			dispatcher.forward(request, response);
			//追加箇所ここまで

		} else {
			//ログイン処理//変更箇所ここから
			//リダイレクト処理
			
			//サーブレットコンテキスト取得
			final String contextPath = request.getServletContext().getContextPath();

			//リダイレクト先のURLを構築
			final String redirectURL = contextPath + "/_HomeServlet2";

			//リダイレクトを行う
			response.sendRedirect(redirectURL);

			//変更箇所ここまで
		}

		//変更箇所ここから		
		//		//フォワード処理
		//		RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
		//		dispatcher.forward(request, response);
		//変更箇所ここまで
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//doGet(request, response);
		System.out.println("Postへ遷移後");
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("user_id");
		String pass = request.getParameter("password");
		String forward = null;

		System.out.println("jsp 送信 id チェック: " + id);//debug
		System.out.println("jsp 送信 pass チェック: " + pass);//debug

		System.out.println("必須チェック前");//debug
		if (Util.validateId(id) && Util.validatePassword(pass)) {

			//書式必須チェック成功時
			System.out.println("必須チェック成功");//debug

			User user = new User(id, pass);

			LoginLogic loginLogic = new LoginLogic();

			boolean isLogin = loginLogic.execute(user);

			if (isLogin) {
				System.out.println("認証成功: islogin ture");//debug
				// 認証成功処理

				HttpSession session = request.getSession();
				session.setAttribute("LoginUser", user);
				//認証成功 Home.jsp へ遷移する↓
				System.out.println(session.getAttribute("LoginUser"));//debug
				
				//変更箇所ここから
				// リダイレクト先の URL を取得する
				//サーブレットコンテキスト取得
				final String contextPath = request.getServletContext().getContextPath();

				//リダイレクト先のURLを構築
				final String redirectURL = contextPath + "/LoginServlet";

				//リダイレクトを行う
				response.sendRedirect(redirectURL);
				//変更箇所ここまで

			} else {
				System.out.println("認証失敗 islogin false");//debug
				// 認証失敗処理

				request.setAttribute("errorMessage", "入力に誤りがあります");
				//認証失敗 MissLogin.jsp へ遷移↓
				forward = "MissLogin.jsp";

				forward = "WEB-INF/jsp/" + forward;//追加箇所

				RequestDispatcher dispatcher = request.getRequestDispatcher(forward);//追加箇所
				dispatcher.forward(request, response);//追加箇所
			}

		}
	}
}