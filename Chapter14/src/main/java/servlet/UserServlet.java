package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Account;
import model.UserLogic;
/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/user.jsp");
		
		dispatcher.forward(request, response);
	}

	//ユーザー登録処理
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String mail = request.getParameter("mail");
		String name = request.getParameter("name");
		String ageStr = request.getParameter("age");
		
		String errorMsg = "";
		
		if (userId == null || userId.isEmpty()) {
			errorMsg += "ユーザーIDが入力されていません。<br>";
		}
		if (pass == null || pass.isEmpty()) {
			errorMsg += "パスワードが入力されていません。<br>";
		}
		if (mail == null || mail.isEmpty()) {
			errorMsg += "メールアドレスが入力されていません。<br>";
		}
		if (name == null || name.isEmpty()) {
			errorMsg += "姓名が入力されていません。<br>";
		}
		if (ageStr == null || ageStr.isEmpty()) {
			errorMsg += "年齢が入力されていません。<br>";
		}
		
		if (!errorMsg.isEmpty()) {
			request.setAttribute("errorMsg", errorMsg);
			
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/user.jsp");
			dispatcher.forward(request, response);
			return;
		}
		int age = Integer.parseInt(ageStr);
		
		Account account =
				new Account(userId, pass, mail, name, age);
		
		UserLogic logic = new UserLogic();
		boolean result = logic.execute(account);
		
		if (result) {
			request.setAttribute("account", account);
			
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/userOK.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("errorMsg", "ユーザー登録に失敗しました");
			
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/user.jsp");
			dispatcher.forward(request, response);
		}
	}

}
