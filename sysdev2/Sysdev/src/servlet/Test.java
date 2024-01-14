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

@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Test() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Home_Dto_ homeDto = new Home_Dto_();

		_HomeSetUpDao homeset = new _HomeSetUpDao();
		homeset.getBlockData(1);

		//マップ変数
		Map<String, String> AppJspFileNames = homeDto.getAreaAndAppJspFileName();

		//debug
		String tempBlockKey = AppJspFileNames.get("1");

		// 値をコンソール出力する
		System.out.println("home AreaAndAppJspFileNameに設定された中身:");
		System.out.println("Test.java key: " + tempBlockKey + "\n Test.java value: " + "nothing");

		String jspFileName = null;

		//debugここから
		if (homeDto.getAreaAndAppJspFileNameByKey("1") != null) {

			System.out.println(homeDto.getAreaAndAppJspFileNameByKey("1"));

		} else {

			System.out.println("get fail");
			jspFileName = "Login";

		}
		//debugここまで

		// JSP AにJSP Bを動的にインクルード
		request.setAttribute("jspBPathA", "/WEB-INF/jsp/" + jspFileName + ".jsp");

		// homeJSPファイルへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/HomeTemp.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
