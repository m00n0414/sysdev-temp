package servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao._HomeSetUpDao;
import model.Home_Dto_;
import model.User;

@WebServlet("/_HomeServlet2")
public class _HomeServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public _HomeServlet2() {
		System.out.println("HomeServlet const");//debug
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//それぞれDto呼び出し、インスタンス化
		User user = new User();
		Home_Dto_ home = new Home_Dto_();

		//debug: test run
		user.setUser_id("12");
		home.setLayout_id(1);

		//Dtoから取得し、変数に保存
		int userId = Integer.parseInt(user.getUser_id());
		int layoutId = home.getLayout_id();

		System.out.println(userId + "," + layoutId);//debug

		//DBから現在layoutIdを取得、表示する

		//Daoインスタンス化
		_HomeSetUpDao dao = new _HomeSetUpDao();

		//DBからブロック情報(jspName)を取得し、dtoへ入力
		dao.getBlockData(layoutId);

		//マップ変数
		Map<String, String> AppJspFileNames = home.getAreaAndAppJspFileName();

		System.out.println("hashmap部分");

		System.out.println("value is: " + AppJspFileNames.get("1"));

		for (Map.Entry<String, String> entry : AppJspFileNames.entrySet()) {
			System.out.println("hashmapループ");
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}

		System.out.println("included jsp");//debug

		// 設定でYouTubeのリンクが送られるservletで取得

		// blockデータとアプリデータを取得

		// homeJSPファイルへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/HomeTemp.jsp");
		dispatcher.forward(request, response);

		System.out.println("success forward");//debug
	}

}
