package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.RegisterUserLogic;
import model.User;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        if (name == null || name.isEmpty()
                || pass == null || pass.isEmpty()) {

            request.setAttribute(
                    "errorMsg",
                    "ユーザー名とパスワードを入力してください");

            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
            dispatcher.forward(request, response);
            return;
        }

        User user = new User(name, pass);

        RegisterUserLogic logic = new RegisterUserLogic();
        boolean result = logic.execute(user);

        if (result) {
            request.setAttribute("user", user);

            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("/WEB-INF/jsp/registerResult.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("errorMsg", "ユーザー登録に失敗しました");

            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
            dispatcher.forward(request, response);
        }
    }
}